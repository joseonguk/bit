/* Entity 역할
 * - 데이터의 저장과 조회, 변경, 삭제 관리
 * - 데이터의 지속성(Persistence) 관리
 * - Data Access Object(DAO)
 */

package exam.oop3.step04;

import java.util.ArrayList;

public class ScoreDao {
	ArrayList<Score> scores = new ArrayList<Score>();
	//int size;
	int cursor;
	
	public ScoreDao() {
		//size = 0;
	}

	public void insert(Score score) {
		//if (size < scores.size()){
			scores.add(score);
			cursor = scores.size();
			//cursor = size;
		//}
  }
	
	public Score nextScore() {
    //if (cursor >= scores.size() || cursor >= scores.size() - 1) 
    if (cursor >= scores.size()-1)
      return null;
    
    return scores.get(++cursor);
  }
  
  public Score previousScore() {
    if (cursor <= 0) 
      return null;
    
    return scores.get(--cursor);
  }
	
  /*
	public ArrayList<Score> toArray() {
		return this.scores;
	}
	*/
  
  public Object[] toArray() {
    return this.scores.toArray();
  }
}
