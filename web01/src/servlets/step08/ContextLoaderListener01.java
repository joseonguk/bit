package servlets.step08;

import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.lang.reflect.Method;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

// myBatis 도입
public class ContextLoaderListener01 implements ServletContextListener {
  static Logger logger = Logger.getLogger(ContextLoaderListener01.class);

  @Override
  public void contextInitialized(ServletContextEvent event) {
    logger.debug("contextInitialized 호출됨...");
    try {
      ServletContext ctx = event.getServletContext();

      // MyBatis 데이터 처리 대행 객체 준비
      // 1) 설정 파일을 읽어들일 때 사용할 도구(InputStream)를 준비한다.
      // 2) SqlSessionBuilder를 준비한다.
      // 3) SqlSessionBuilder로부터 SqlSessionFactory를 얻는다.
      // 4) SqlSessionFactory로부터 SqlSession을 얻는다.
      // ex) 망치 <- 망치공장 <-망치공장건설사 + 설계도면
      String resource = "servlets/step08/mybatis-config.xml";
      // 자바 클래스 경로(classpath)에서 MyBatis 설정파일을 찾는다.
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
          .build(inputStream);

      ScoreDao scoreDao = new ScoreDao();
      scoreDao.setSqlSessionFactory(sqlSessionFactory);

      // 페이지 컨트롤러를 ServletContext에 보관함.
      // => servlets 패키지에서 @Component 애노테이션이 들어 있는 클래스를 찾아 인스턴스를 생성하라!
      // => 생성된 인스턴스는 ServletContext에 보관하라!
      // 1. 웹 애플리케이션의 클래스 경로를 알아낸다.
      // => 웹 애플리케이션이 배치된 폴더 /WEB-INF/classes
      // => 예)
      // ...\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\web01\WEB-INF\classes
      logger.debug(ctx.getRealPath("/WEB-INF/classes/servlets/step08"));
      String pageControllerPath = ctx
          .getRealPath("/WEB-INF/classes/servlets/step08");

      // 2. File 객체를 사용하여 해당 servlets/step08 폴더에 들어 있는 클래스 이름을 알아낸다.
      File pageControllerDir = new File(pageControllerPath);
      String[] files = pageControllerDir.list(new FilenameFilter() {
        // 해당 폴더를 읽어와서 list에 포함시킬지 말지 확인함
        // 파일의 개수만큼 실행됨
        // .class만 출력하기 위해서
        @Override
        public boolean accept(File dir, String name) {
          if (name.endsWith(".class"))
            return true;
          else
            return false;
        }
      });

      // 3. 클래스 이름으로 클래스를 로딩한다.
      // => servlets/step08 패키지에 소속된 클래스를 로딩한다.
      Class clazz = null;
      Component compAnno = null;
      PageController pageController = null;
      Method method = null;
      
      for (String filename : files) {
        clazz = Class.forName("servlets.step08."
            + filename.substring(0, filename.indexOf('.')));
        // 파일 이름을 0부터 .이있는곳 까지 뽑아냄
        logger.debug("==>" + clazz.getName());

        // 4. 클래스 정보 객체로부터 Component 애노테이션 정보를 추출한다.
        compAnno = (Component) clazz.getAnnotation(Component.class);

        // 5. 만약 Component 애노테이션이 있다면 해당 클래스의 인스턴스를 생성한다.
        if (compAnno != null) {
          logger.debug("        value=" + compAnno.value());
          pageController = (PageController)clazz.newInstance();
          logger.debug("        "+clazz.getSimpleName() + " 인스턴스 생성됨");
          // 로딩된 정보를 가지고 인스턴스를 생성할 수 있음
          
          // 6. 그리고 의존 객체를 주입한다.
          // setScoreDao를 호출해야 하므로 불러내서 method로 넘김
          method = clazz.getMethod("setScoreDao", ScoreDao.class);
          logger.debug("        setScoreDao() 메서드 정보 꺼내기"); 
          
          method.invoke(pageController, scoreDao);
          logger.debug("        setScoreDao() 호출");
          
          // 7. ServletsContext에 보관한다.
          //compAnno.value()로 불러내서 pageController에 보관
          ctx.setAttribute(compAnno.value(), pageController);
          logger.debug("        " + clazz.getSimpleName() + " 인스턴스를 ServletContext 보관");
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    logger.debug("contextDestroyed 호출됨...");
  }
}
