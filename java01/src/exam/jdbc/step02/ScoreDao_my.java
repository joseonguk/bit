/* close() 정석!
 * - 오류가 발생했을 때도 정상적으로 연결을 끊을 수 있도록 처리하낟.
 * - try ... catch ... finally
 * 
 * Auto generated key 가져오기
 * - execute~~~(sql, Statement.RETURN_GENERATED_KEYS);
 * - getGeneratedKeys()
 */

package exam.jdbc.step02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScoreDao_my {
  Score currScore;

  public ScoreDao_my() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb", 
          "bit", "1111"   );
      stmt = con.createStatement();
      
      rs = stmt.executeQuery(
          "select sno, name, kor, eng, math "
          + " from scores order by sno desc limit 1");
      
      if (rs.next()) {
        currScore = new Score();
        currScore.setNo(rs.getInt("sno"));
        currScore.setName(rs.getString("name"));
        currScore.setKor(rs.getInt("kor"));
        currScore.setEng(rs.getInt("eng"));
        currScore.setMath(rs.getInt("math"));
      }
      
      // return;    리턴이 되기 전에 finally가 먼저됨
    } catch (Exception e) {
      e.printStackTrace();
    } finally { // 정상적으로 수행하든, 오류가 발생하든 간에 반드시 수행하는 블록
      // 즉, try 블록이나 catch 블록을 나가기 전에 반드시 finally 블록을 수행한다.
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      try { con.close(); } catch (SQLException e) {}
    }
  }

  public void insert(Score score) {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;  // 자동 생성된 pk값을 가져오는 역할자
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb", 
          "bit", "1111"   );
      stmt = con.createStatement();
      
      int count = stmt.executeUpdate(
          "insert into scores (name, kor, eng, math)"
          + " values ('" + score.getName() + "'," + 
              score.getKor() + "," + 
              score.getEng() + "," + 
              score.getMath() + ")",
              Statement.RETURN_GENERATED_KEYS);
      
      if (count == 1) {
        // 입력 성공 후에 자동 생성된 PK 값 가져오기
        rs = stmt.getGeneratedKeys();       // 1) 자동 생성 PK값 가져오는 역할자 얻기
        rs.next();                          // 2) PK값 가져오기
        //System.out.println(rs.getInt(1));   // 3) 출력하기
        score.setNo(rs.getInt(1));
        currScore = score;
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      try { con.close(); } catch (SQLException e) {}
    }
  }

  public Score next() {
    if (currScore == null) return null;
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb", 
          "bit", "1111"   );
      stmt = con.createStatement();
      
      // where 절에 서브 쿼리 적용
      rs = stmt.executeQuery(
          "select sno, name, kor, eng, math"+
              " from scores " +
              " where sno = (select min(SNO) from scores  where sno > " + 
              currScore.getNo() + ");");
      
      if (rs.next()) {
        currScore = new Score();
        
        currScore.setNo(rs.getInt("sno"));
        currScore.setName(rs.getString("name"));
        currScore.setKor(rs.getInt("kor"));
        currScore.setEng(rs.getInt("eng"));
        currScore.setMath(rs.getInt("math"));
        
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
      try { con.close(); } catch (SQLException e) {}
    }
  }

  public Score previous() {
    if (currScore == null) return null;
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb", 
          "bit", "1111"   );
      stmt = con.createStatement();
      
      // where 절에 서브 쿼리 적용
      rs = stmt.executeQuery(
          "select sno, name, kor, eng, math"+
              " from scores " +
              " where sno = (select max(SNO) from scores  where sno < " + 
              currScore.getNo() + ");");
      
      if (rs.next()) {
        currScore = new Score();
        
        currScore.setNo(rs.getInt("sno"));
        currScore.setName(rs.getString("name"));
        currScore.setKor(rs.getInt("kor"));
        currScore.setEng(rs.getInt("eng"));
        currScore.setMath(rs.getInt("math"));
        
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
      try { con.close(); } catch (SQLException e) {}
    }
  }
  
  public Score getCurrentScore() {
    return currScore;
  }

  public void delete() {
    Connection con = null;
    Statement stmt = null;
    
    
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb", 
          "bit", "1111"   );
      stmt = con.createStatement();
      
      int count = stmt.executeUpdate(
          "delete from scores where sno =" + currScore.getNo());
      
     
      if (count == 1) {
        // 정상적으로 삭제 했으면 이전 데이터를 가져와야 한다.
       Score score = previous();
       
       if (score == null) {
         score = next();
         if(score == null){
           currScore = null;
         }
       }
      }
      
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally { 
      try { stmt.close();} catch (SQLException e) {}
      try { con.close(); } catch (SQLException e) {}
    }
    
  }
}
