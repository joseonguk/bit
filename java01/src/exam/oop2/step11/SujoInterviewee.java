package exam.oop2.step11;

/* 인터페이스 구현
 * - 인터페이스에 선언된 모든 메서드를 구현해야 한다.
 */

public class SujoInterviewee implements Interviewee{
	// Interviewer 클래스에 의해서 호출되는 메서드이다.
	// 내가 등록한 객체의 메서드가 다른 객체에 의해 호출된다면
	// => "callback" 메서드가 호출된다.
  public void hi() {
	  System.out.println("네 안녕하세요. 누구세요?");
  }

  public void bye() {
	  System.out.println("흐어흐어흐어");
  }

}
