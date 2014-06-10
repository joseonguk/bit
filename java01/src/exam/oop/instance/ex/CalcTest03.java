package exam.oop.instance.ex;

public class CalcTest03 {
	public static void main(String[] args) {
	  
	  // 5 + 3 * 7 (전제조건 : 연산자 우선 순위 무시)
		Calculatior03 calc1 = new Calculatior03();
		Calculatior03 calc2 = new Calculatior03();
		
		Calculatior03.init(calc1, 5);
		Calculatior03.puls(calc1, 3);
		Calculatior03.multiple(calc1, 7);
	 
	  
	  System.out.println(calc1.result);
  }
}
