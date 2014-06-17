package exam.oop2.step11;

public class Test01 {
	public static void main(String[] args) {
	  SujoInterviewee sujo = new SujoInterviewee();
	  
	  Interviewer iv = new Interviewer();
	  
	  iv.addInterviewee(sujo);
	  iv.interview();
  }
}
