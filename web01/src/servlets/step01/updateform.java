package servlets.step01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/updateform")
public class updateform extends HttpServlet{
  private static final long serialVersionUID = 1L;
  DbConnectionPool dbConnectionPool;
  ScoreDao scoreDao;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    
    try{
      dbConnectionPool = new DbConnectionPool(
          "com.mysql.jdbc.Driver",
          "jdbc:mysql://localhost:3306/bitdb", 
          "bit", "1111");
      scoreDao = new ScoreDao();
      scoreDao.setDbConnectionPool(dbConnectionPool);
    } catch(Exception e) { 
      e.printStackTrace();
    }
  }
  
  @Override
  public void destroy() {
    super.destroy();
    
    dbConnectionPool.closeAll();
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
      
      response.setContentType("text/html; charset=UTF-8"); 
      PrintWriter out = response.getWriter();
      
      int no = Integer.parseInt(request.getParameter("no"));
      
      try{
      Score score = scoreDao.getScore(no);
      
      
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>성적 변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("  <h1>성적 변경</h1>");
      out.println("  <form action='/web01/score/updateform1' method='get'>");
      out.println("  <input type='hidden' name='no' value="+ score.getNo() +"><br>");
      out.println("  이름 : <input type='text' name='name' value="+ score.getName() +"><br>");
      out.println("  국어 : <input type='text' name='kor' value="+ score.getKor() +"><br>");
      out.println("  영어 : <input type='text' name='eng' value="+ score.getEng() +"><br>");
      out.println("  수학 : <input type='text' name='math' value="+ score.getMath()+"><br>");
      out.println("        <input type='submit' value='변경'>");
      out.println("  </form>");

      out.println("</body>");
      out.println("</html>");
      
    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
