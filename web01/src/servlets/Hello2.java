package servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Hello2 extends GenericServlet {

  // Load balancer(분배기 : 서로 균등하게 맞춰주는 것)
  // 서블릿 정보가 다른 정보로 이전될 수도 있으므로 인스턴스 정보를 알아야함
  // 그러므로 시리얼라이져블 인터페이스 버전넘버를 줘야함
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest arg0, ServletResponse arg1)
      throws ServletException, IOException {
    System.out.println("Hello2------------------------------");

  }

}
