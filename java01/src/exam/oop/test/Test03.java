/** 생성자를 여러 개 정의하기
 * 1)
 */
package exam.oop.test;

import exam.oop.Score3;

public class Test03 {

	public static void main(String[] args) {
		// 호출할 생성자를 지정하지 않으면 오류!
		//Score3 score = new Score3;
		
		// 호출할 생성자를 지정하는 방법 => 파라미터 값으로 지정
		// 파라미터 값으로 아무것도 주지 않으면 기본 생성자를 지정하는 것이다.
		Score3 score = new Score3();		// 인스턴스 생성후 기본 생성자 호출됨
	}

}
