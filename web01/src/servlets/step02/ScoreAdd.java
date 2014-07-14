package servlets.step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/step02/add")
public class ScoreAdd extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    Score score = new Score();
    score.setName(request.getParameter("name"));
    score.setKor(Integer.parseInt(request.getParameter("kor")));
    score.setEng(Integer.parseInt(request.getParameter("eng")));
    score.setMath(Integer.parseInt(request.getParameter("math")));
    
    ServletContext ctx = this.getServletContext();
    ScoreDao scoreDao =(ScoreDao)ctx.getAttribute("scoreDao");
    scoreDao.insert(score);
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    
    // 웹 브라우저에게 1초 후에 list를 요청할 것을 알리는 명령 심는다.
    out.println("<meta http-equiv='Refresh' content='1; url=list'>");
    
    out.println("<title>성적 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p>등록 성공입니다.</p>");
    out.println("</body>");
    out.println("</html>");
  }
}
