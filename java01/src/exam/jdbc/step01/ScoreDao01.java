/* Entity 역할
 * - 데이터의 저장과 조회, 변경, 삭제 관리
 * - 데이터의 지속성(Persistence) 관리
 * - Data Access Object(DAO)
 */

package exam.jdbc.step01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScoreDao01 {
  static int count;

  public ScoreDao01() {
    try {

      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb", "bit", "1111");
      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery(
          "SELECT * FROM scores where sno = (select max(sno) from scores) ");

      if (rs.next()) {
        count = rs.getInt("sno") + 1;
      }

      rs.close();
      stmt.close();
      con.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void insert(Score score) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb", "bit", "1111");
      Statement stmt = con.createStatement();

      int count = stmt
          .executeUpdate("insert into scores (name, kor, eng, math)"
              + " value ('" + score.getName() + "'," + score.getKor() + ","
              + score.getEng() + "," + score.getMath() + ")");

      if (count == 1) {
        System.out.println("입력 완료!");
      }

      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Score nextScore() {
    Score scores = new Score();

    try {

      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb", "bit", "1111");
      Statement stmt = con.createStatement();

      // ResultSet rs = stmt.executeQuery(
      // "SELECT * FROM scores where sno = (select max(sno + "+ count++ +
      // ") from scores)");

      ResultSet rs = stmt.executeQuery(
          "SELECT * FROM scores where sno >" + count++ + " order by sno asc limit 1;");

      if (!rs.next()) {
        count--;
        return null;
      }

      scores.setName(rs.getString("name"));
      scores.setKor(rs.getInt("kor"));
      scores.setEng(rs.getInt("eng"));
      scores.setMath(rs.getInt("math"));

      rs.close();
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return scores;
  }

  public Score previousScore() {
    Score scores = new Score();

    try {

      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/bitdb", "bit", "1111");
      Statement stmt = con.createStatement();

      // ResultSet rs = stmt.executeQuery(
      // "SELECT * FROM scores where sno = (select max(sno + "+ count-- +
      // ") from scores)");

      ResultSet rs = stmt.executeQuery(
          "SELECT * FROM scores where sno <" + count-- + " order by sno desc limit 1;");

      if (!rs.next()) {
        count = 1;
        return null;
      }

      scores.setName(rs.getString("name"));
      scores.setKor(rs.getInt("kor"));
      scores.setEng(rs.getInt("eng"));
      scores.setMath(rs.getInt("math"));

      rs.close();
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return scores;
  }
}
