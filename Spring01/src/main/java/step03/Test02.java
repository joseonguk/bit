package step03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step03/application-context2.xml"});
  
    Car c1 = (Car)ctx.getBean("c1");
    Car c2 = (Car)ctx.getBean("c2");
    Engine e1 = (Engine)ctx.getBean("e1");
    
    System.out.println(c1);
    System.out.println(c2);
     
    // scope이 prototype인 경우, getBean() 호출할 떄 생성된다
    if(e1 == c1.getEngine()) System.out.println("e1 == c1.getEngine()");
    if(e1 == c2.getEngine()) System.out.println("e1 == c2.getEngine()");
    
  }
}
