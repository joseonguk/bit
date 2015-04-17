package exam.oop.test_oop;

public class Score2 {
	
	//Score가 준비하는 메모리를 선언
	public String name;
	public int kor;
	public int eng;
	public int math;
	public int total;
	public float average;
	
	public Score2(){
		
	}
	// 이미 생성자가 있기 때문에 기본 생성자가 자동으로 추가되지 않는다.
	public Score2(String name, int kor, int eng, int math) {
		
		this.name = name;
		this.eng = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = this.total / 3.0f;
		
  }
}