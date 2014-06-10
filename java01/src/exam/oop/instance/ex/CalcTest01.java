package exam.oop.instance.ex;

public class CalcTest01 {
	public static void main(String[] args) {
	  int result = 0;
	  
	  // 5 + 3 * 7 (전제조건 : 연산자 우선 순위 무시)
	  result = Calculatior01.puls(5, 3);
	  result = Calculatior01.multiple(result, 7);
	  
	  System.out.println(result);
  }
}
