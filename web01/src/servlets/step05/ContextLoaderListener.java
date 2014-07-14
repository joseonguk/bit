package servlets.step05;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// PageController 객체를 준비한다.
public class ContextLoaderListener implements ServletContextListener {

  // 웹 애플리케이션이 시작될 때 호출된다.
  // => 웹 애플리케이션을 위한 공용 자원을 준비한다.
  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
      ServletContext ctx = event.getServletContext();
      DbConnectionPool dbConnectionPool = new DbConnectionPool(
          ctx.getInitParameter("driver"), 
          ctx.getInitParameter("url"),
          ctx.getInitParameter("username"), 
          ctx.getInitParameter("password"));
      ScoreDao scoreDao = new ScoreDao();
      scoreDao.setDbConnectionPool(dbConnectionPool);

      // 페이지 컨트롤러를 ServletContext에 보관함
      ScoreList scoreList = new ScoreList();
      scoreList.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step05/list.do", scoreList);

      ScoreDelete scoreDelete = new ScoreDelete();
      scoreDelete.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step05/delete.do", scoreDelete);

      ScoreAdd scoreAdd = new ScoreAdd();
      scoreAdd.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step05/scoreAdd.do", scoreAdd);

      ScoreUpdate scoreUpdate = new ScoreUpdate();
      scoreUpdate.setScoreDao(scoreDao);
      ctx.setAttribute("/score/step05/update.do", scoreUpdate);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 웹 애플리케이션이 종료되기 직전에 호출된다.
  // => 웹 애플리케이션이 사용한 공용 자원을 해제한다.
  @Override
  public void contextDestroyed(ServletContextEvent event) {
    ServletContext ctx = event.getServletContext();
    DbConnectionPool dbConnectionPool = (DbConnectionPool) ctx
        .getAttribute("dbConnectionPool");
    dbConnectionPool.closeAll();
  }
}
