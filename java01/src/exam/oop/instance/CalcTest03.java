/** 문제: 동시에 여러 개의 계산을 수행한다면?
 * - 클래스 변수는 오로지 하나만 존재한다. => 여러 개의 계산 불가!
 */
package exam.oop.instance;

public class CalcTest03 {

	public static void main(String[] args) {
		
		// 5 + 3 * 7 (전제조건 : 연산자 우선 순위 무시)
		// 6 - 2 + 3
		Calculatior03 calc1 = new Calculatior03();
		Calculatior03 calc2 = new Calculatior03();
		
		Calculatior03.init(calc1, 5);
		Calculatior03.init(calc2, 6);
		
		Calculatior03.plus(calc1, 3);
		Calculatior03.minus(calc2, 2);
		
		Calculatior03.multiple(calc1, 7);
		Calculatior03.plus(calc2, 3);
		
		System.out.println(calc1.result);
		System.out.println(calc2.result);
	}

}
