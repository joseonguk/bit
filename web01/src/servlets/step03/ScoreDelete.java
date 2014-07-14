package servlets.step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/step03/delete")
public class ScoreDelete  extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {

      int no = Integer.parseInt(request.getParameter("no"));
    
      ServletContext ctx = this.getServletContext();
      ScoreDao scoreDao =(ScoreDao)ctx.getAttribute("scoreDao");
      scoreDao.delete(no);
      
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"UTF-8\">");
      
      // 웹 브라우저에게 1초 후에 list를 요청할 것을 알리는 명령 심는다.
      out.println("<meta http-equiv='Refresh' content='1; url=list'>");
      
      out.println("<title>성적 삭제</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<p>삭제 성공입니다.</p>");
      
      
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03/copyright");
      rd.include(request, response);
      
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      // 오류가 발생하면 /score/step03/error 서블릿으로 위임한다.
      // 요청 배달자를 통해 요청을 해당 서블릿으로 배달한다.
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03/error");
      
      // ErrorSErvlet에 실행을 위임하기 전에 ServletRequest 보관함에 오류 정보를 담에서 보낸다.
      request.setAttribute("error", e);
      
      rd.forward(request, response);
    }
  }

}














