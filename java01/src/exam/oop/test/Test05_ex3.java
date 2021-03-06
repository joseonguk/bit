/** String 클래스
 * - immutable 객체이다.
 * - 인스턴스의 값을 바꿀 수 없다.
 * 
 ** StringBuffer클래스
 * - mutable 객체이다.
 * - 값을 변경할 수 있다
 */


package exam.oop.test;

public class Test05_ex3 {
	
	public static void main(String[] args) {
		String s1 = new String("abcdef");
		String s2 = s1.replace('d', 'x');
		
		System.out.println(s1);
		System.out.println(s2);
		
		StringBuffer sb1 = new StringBuffer("abcdef");
		StringBuffer sb2 = sb1.replace(3, 5, "x");
		
		System.out.println(sb1);
		System.out.println(sb2);
		
	}
}
