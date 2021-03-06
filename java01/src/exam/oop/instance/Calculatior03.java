/** 3. 인스턴스 변수: 함수들의 중간 작업 결과를 개별적으로 보관하는 변수
 * - 문법: 데이터 타입 변수명;
 * - 인스턴스 변수는 new 명령을 통해서만 준비된다.
 */

package exam.oop.instance;

public class Calculatior03 {
	// 인스턴스 변수 선언 - 데이터를 개별적으로 관리하고 싶다면 클래스 변수 대신 인스턴스 변수를 선언하라.
	
	int result;
	
	public static void init(Calculatior03 that, int value) {
		that.result = value;
	}
	
	public static void plus(Calculatior03 that, int value) {
		//Calculatior02.result = Calculatior02.result + value;
		that.result += value;
	}
	public static void minus(Calculatior03 that, int value) {
		that.result -= value;
		
	}
	public static void multiple(Calculatior03 that, int value) {
		that.result *= value;
		
	}
	public static void divide(Calculatior03 that, int value) {
		that.result /= value;
		
	}
}
