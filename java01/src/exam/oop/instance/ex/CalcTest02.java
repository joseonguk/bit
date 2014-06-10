package exam.oop.instance.ex;

public class CalcTest02 {
	public static void main(String[] args) {
	  
	  // 5 + 3 * 7 (전제조건 : 연산자 우선 순위 무시)
		Calculatior02.init(5);
		Calculatior02.puls(3);
		Calculatior02.multiple(7);
	 
	  
	  System.out.println(Calculatior02.result);
  }
}
