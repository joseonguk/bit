package exam.oop2.step09;

import exam.oop2.step09.sub.A;

/* A 클래스와 다른 패키지에 있는 Test02에서 접근 
 * - 그러나, A의 자식 클래스이다
 */

public class Test03 extends A{
	public static void main(String[] args) {
	  A p = new A();
	  p.a = 20;	
	  //p.b = 30;	// 패키지가 달라서 오류!
	  //p.c = 40; // 패키지가 다르다. 자식 클래스인데? 오류?
	  //A라는 클래스의 객체를 불러와서 상속 받은게 아니기 때문에 오류임
	  //p.d = 50;	// 비공개
	  
	  p.m1();
	  //p.m2();	// default
	  //p.m3();	// protected. 자식클래스인데 왜? 오류!
	  //p.m4();	// private
  }
	
	public void test() {
		// A로부터 상속 받은 변수와 메서드 사용
		a = 20;
		//b = 30;	
		c = 40;
		//d = 50;
		
		m1();
	  //m2();	// default
	  m3();	// protected
	  //m4();	// private
	}
}
