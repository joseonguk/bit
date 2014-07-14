package servlets.step08;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

// => DAO 및 SqlSessionFactory 객체도 SErvletContext에 보관한다.
// => setter 메서드를 찾아서 보관한다.

public class ContextLoaderListener implements ServletContextListener {
  static Logger logger = Logger.getLogger(ContextLoaderListener.class);
  ServletContext ctx;
  
  @Override
  public void contextInitialized(ServletContextEvent event) {
    logger.debug("contextInitialized 호출됨...");
    try {
      ctx = event.getServletContext();

      prepareMyBatis();

      String[] classnames = getClassNames();
      
      prepareObjects(classnames);
      
      prepareDependancies();
          
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // MyBatis 준비
  private void prepareMyBatis() throws IOException {
    String resource = "servlets/step08/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = 
        new SqlSessionFactoryBuilder().build(inputStream);
    ctx.setAttribute("sqlSessionFactory", sqlSessionFactory);
  }

  // ClassName을 가져옴 
  private String[] getClassNames() throws Exception{
    logger.debug(ctx.getRealPath("/WEB-INF/classes/servlets/step08"));
    File classDir = new File(
        ctx.getRealPath("/WEB-INF/classes/servlets/step08"));
    
    return classDir.list(new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        if (name.endsWith(".class")) return true;
        else return false;
      }
    });
  }

  // 클래스 이름을 받아서 반복문 받아서 로딩하고 인스턴스 생성 애노테이션 뽑음
  private void prepareObjects(String[] classnames) throws Exception{
    Class<?> clazz = null;
    Object instance = null;
    Component compAnno = null;
    
    // 클래스를 반복하면서 로딩함
    for (String classname : classnames) {
      clazz = loadClass(classname);
      compAnno = getComponentAnnotation(clazz);
      if(compAnno != null){
        instance = createInstance(clazz);
        ctx.setAttribute(compAnno.value(), instance);
      }
    }
  }
  
  // 의존객체 준비 
  // ctx에 보관된 인스턴스 꺼냄 
  // 이름 꺼내고 의존객체 주입
  private void prepareDependancies() throws Exception {
    Enumeration<String> instanceNames = ctx.getAttributeNames();
    Object instance = null;
    
    String instanceName = null;
    while(instanceNames.hasMoreElements()){
      instanceName = instanceNames.nextElement();
      instance = ctx.getAttribute(instanceName);
    
      injectDependancy(instance);
    }
  }

  // 의존 객체를 주입하는 메서드
  // 클래스정보 가져와서 메서드 목록 가져옴
  // 
  private void injectDependancy(Object instance) throws Exception{
    Method[] methods = instance.getClass().getMethods();
    Object dependancy = null;
    for(Method method : methods){
      // 넘어온 메서드중 set이라는 이름이고 파라미터 개수가 1인것만 대상
      if(method.getName().startsWith("set") 
          && method.getParameterCount() == 1){   // setter 메서드인 경우
        logger.debug(instance.getClass().getSimpleName() + 
            " : " + method.getName());
        
        // 넘어온 메서드중 ServletContext에서 의존 객체를 찾아서 dependancy로 넘겨줌
        dependancy = findDependancyFromServletContext(
            method.getParameters()[0].getType());
        
        if (dependancy != null) { // setter 메서드의 의존 객체를 찾앗다면, setter 호출
          logger.debug(method.getName() + " 호 출");
          method.invoke(instance, dependancy);
        }
      }
    }
  }
  
  // 의존 객체 리턴
  private Object findDependancyFromServletContext(Class<?> clazz){
    logger.debug("파라미터 찾기 =>" + clazz.getSimpleName() + " 타입의 인스턴스");
    Enumeration<String> instanceNames = ctx.getAttributeNames();
    Object instance = null;
    
    String instanceName = null;
    // Enumeration은 for문으로 뽑아 낼수 없으므로 while사용
    // 보관된것을 뽑아 내야햄 
    while(instanceNames.hasMoreElements()){
      instanceName = instanceNames.nextElement();
      instance = ctx.getAttribute(instanceName);
      if(instance != null && clazz.isInstance(instance) ){
        return instance;
      }
    }
    return null;
  }
  
  // 인스턴스 생성
  private Object createInstance(Class<?> clazz) throws InstantiationException,
      IllegalAccessException {
    Object instance = clazz.newInstance();
    logger.debug("        "+clazz.getSimpleName() + " 인스턴스 생성됨");
    return instance;
  }

  // 애노테이션 가져옴
  private Component getComponentAnnotation(Class<?> clazz) {
    return (Component)clazz.getAnnotation(Component.class);
  }

  // 클래스 로딩함
  private Class<?> loadClass(String classname) throws ClassNotFoundException {
    Class<?> clazz = Class.forName("servlets.step08."
        + classname.substring(0, classname.indexOf('.')));
    logger.debug("==>" + clazz.getName());
    return clazz;
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    logger.debug("contextDestroyed 호출됨...");
  }
}
