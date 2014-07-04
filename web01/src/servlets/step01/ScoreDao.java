/* preparedStatement 적용
 * - SQL 템플릿을 정의한 후, IN-PARAMETER 값을 넣는 방법
 * - 장점
 *   1) SQL문이 간결해진다.
 *   2) IN-PARAMETER를 통해 값을 입력하기 때문에 SQL문을 조작할 수 없다.
 *   3) 바이너리 데이터를 입력할 수 있다.
 *   4) 반복하여 작업을 수행할 때 속도가 빠르다.
 *      => 이유 : SQL문을 미리 만들어 놓고 값만 입력하여 실행하기 때문이다.
 */

package servlets.step01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ScoreDao {
  DbConnectionPool dbConnectionPool;
  Score currScore;
  
  public Score getScore(int no) throws Exception{
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbConnectionPool.getConnertion();
      stmt = con.createStatement();
      
      rs = stmt.executeQuery(
          "select name, kor, eng, math "
          + " from scores where sno =" + no);
      
      Score score = null;
      
      if (rs.next()) {
        score = new Score();
        score.setNo(no);
        score.setName( rs.getString("name"));
        score.setKor( rs.getInt("kor"));
        score.setEng( rs.getInt("eng"));
        score.setMath( rs.getInt("math"));  
        
      }
      return score;
      
    } catch (Exception e) {
      throw e; 
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }
  
  
  public ArrayList<Score> list() throws Exception{
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbConnectionPool.getConnertion();
      stmt = con.createStatement();
      
      rs = stmt.executeQuery(
          "select sno, name, kor, eng, math "
          + " from scores order by sno desc");
      
      ArrayList<Score> scores = new ArrayList<Score>();
      Score score = null;
      
      while (rs.next()) {
        score = new Score();
        score.setNo( rs.getInt("sno"));
        score.setName( rs.getString("name"));
        score.setKor( rs.getInt("kor"));
        score.setEng( rs.getInt("eng"));
        score.setMath( rs.getInt("math"));        
        scores.add(score);
      }
      
      return scores;
      
    } catch (Exception e) {
      throw e; 
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }
  
  // dbConnectionPool 
  public void setDbConnectionPool(DbConnectionPool dbConnectionPool) {
    this.dbConnectionPool = dbConnectionPool;
  }

  public int insert(Score score) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbConnectionPool.getConnertion();
      
      stmt = con.prepareStatement(
          "insert into scores (name, kor, eng, math)"+ 
          " value(? ,?, ?, ?)");
      
      // IN-PARAMENTER의 타입에 따라 setXxxx(인덱스, 값) 호출한다.
      stmt.setString(1, score.getName());
      stmt.setInt(2, score.getKor());
      stmt.setInt(3, score.getEng());
      stmt.setInt(4, score.getMath());
      
      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public Score next() {
    if (currScore == null) return null;
    
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbConnectionPool.getConnertion();
      
      stmt = con.prepareStatement(
          "select sno, name, kor, eng, math" +
          " from scores " +
          " where sno = ( select min(sno) from scores where sno > ?)");
      
      stmt.setInt(1, currScore.getNo());
      
      rs = stmt.executeQuery();
      
      if (rs.next()) {
        currScore = new Score();
        currScore.setNo( rs.getInt("sno"));
        currScore.setName( rs.getString("name"));
        currScore.setKor( rs.getInt("kor"));
        currScore.setEng( rs.getInt("eng"));
        currScore.setMath( rs.getInt("math"));   
        return currScore;
        
      } else {
        return null;
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public Score previous() {
    if (currScore == null) return null;
    
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbConnectionPool.getConnertion();
      
      stmt = con.prepareStatement(
          "select sno, name, kor, eng, math" +
          " from scores " +
          " where sno = ( select max(sno) from scores where sno < ?)");
      
      stmt.setInt(1, currScore.getNo());
      
      rs = stmt.executeQuery();
      
      if (rs.next()) {
        currScore = new Score();
        currScore.setNo( rs.getInt("sno"));
        currScore.setName( rs.getString("name"));
        currScore.setKor( rs.getInt("kor"));
        currScore.setEng( rs.getInt("eng"));
        currScore.setMath( rs.getInt("math"));   
        return currScore;
        
      } else {
        return null;
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      return null;
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }
  
  public int delete(int no) throws Exception{
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbConnectionPool.getConnertion();
      stmt = con.prepareStatement(
          "delete from scores where sno = ?");
      
      stmt.setInt(1, no);
      
      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public Score getCurrentScore() {
    return currScore;
  }

  public int update(Score score) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbConnectionPool.getConnertion();
      stmt = con.prepareStatement(
          "update scores set name = ?, kor = ?, eng = ?, math = ? where sno = ? ");
             
      
      stmt.setString(1, score.getName());
      stmt.setInt(2, score.getKor());
      stmt.setInt(3, score.getEng());
      stmt.setInt(4, score.getMath());
      stmt.setInt(5, score.getNo());
      
      return stmt.executeUpdate();
      
      
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      //try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }
}










