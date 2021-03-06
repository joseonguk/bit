/* preparedStatement 적용
 * - SQL 템플릿을 정의한 후, IN-PARAMETER 값을 넣는 방법
 * - 장점
 *   1) SQL문이 간결해진다.
 *   2) IN-PARAMETER를 통해 값을 입력하기 때문에 SQL문을 조작할 수 없다.
 *   3) 바이너리 데이터를 입력할 수 있다.
 *   4) 반복하여 작업을 수행할 때 속도가 빠르다.
 *      => 이유 : SQL문을 미리 만들어 놓고 값만 입력하여 실행하기 때문이다.
 */

package exam.jdbc.step04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScoreDao {
  DbConnectionPool dbConnectionPool;
  Score currScore;
  
  public void prepare() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbConnectionPool.getConnertion();
      stmt = con.createStatement();
      
      rs = stmt.executeQuery(
          "select sno, name, kor, eng, math "
          + " from scores order by sno desc limit 1");
      
      if (rs.next()) {
        currScore = new Score();
        currScore.setNo( rs.getInt("sno"));
        currScore.setName( rs.getString("name"));
        currScore.setKor( rs.getInt("kor"));
        currScore.setEng( rs.getInt("eng"));
        currScore.setMath( rs.getInt("math"));        
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
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

  public void insert(Score score) {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null; // 자동 생성된 PK 값을 가져오는 역할자
    
    try {
      con = dbConnectionPool.getConnertion();
      
      stmt = con.prepareStatement(
          "insert into scores (name, kor, eng, math)"+ 
          " value(? ,?, ?, ?)", 
          Statement.RETURN_GENERATED_KEYS);
      
      // IN-PARAMENTER의 타입에 따라 setXxxx(인덱스, 값) 호출한다.
      stmt.setString(1, score.getName());
      stmt.setInt(2, score.getKor());
      stmt.setInt(3, score.getEng());
      stmt.setInt(4, score.getMath());
      
      int count = stmt.executeUpdate();
      
      if (count == 1) {
        // 입력 성공 후에 자동 생성된 PK 값 가져오기
        rs = stmt.getGeneratedKeys(); //1) 자동 생성 PK값 가져오는 역할자 얻기 
        rs.next(); // 2) PK 값 가져오기 
        score.setNo( rs.getInt(1)); // 3) DBMS에서 자동 생성된 PK 값을 Score에 저장. 
        currScore = score;
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
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
  
  public void delete() {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbConnectionPool.getConnertion();
      stmt = con.prepareStatement(
          "delete from scores where sno = ?");
      
      stmt.setInt(1, currScore.getNo());
      
      int count = stmt.executeUpdate();
      
      if (count == 1) {
        // 정상적으로 삭제했으면 이전 데이터를 가져와야 한다.
 
        Score score = previous();
        if (score == null) {
          score = next();
          if (score == null) {
            currScore = null;
          }
        }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally { 
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public Score getCurrentScore() {
    return currScore;
  }

  public void update() {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbConnectionPool.getConnertion();
      stmt = con.prepareStatement(
          "update scores set name = ?, kor = ?, eng = ?, math = ? where sno =?");
             
      
      stmt.setString(1, currScore.getName());
      stmt.setInt(2, currScore.getKor());
      stmt.setInt(3, currScore.getEng());
      stmt.setInt(4, currScore.getMath());
      stmt.setInt(5, currScore.getNo());
      
      int count = stmt.executeUpdate();
      
      if (count == 1) {
        System.out.println("변경성공");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally { 
      //try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }
}










