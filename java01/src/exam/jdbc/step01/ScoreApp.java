package exam.jdbc.step01;

/* ScoreFrame 사용
 * - 상속 기법을 이용하여 Frame 기능을 확장함.
 */

public class ScoreApp{
	public static void main(String[] args) {
	 ScoreFrame sf = new ScoreFrame();
	 ScoreDao scoreDao = new ScoreDao();
	 sf.setScoreDao(scoreDao);
	 sf.setVisible(true);
	 
  }
}
