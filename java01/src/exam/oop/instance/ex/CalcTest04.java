package exam.oop.instance.ex;

public class CalcTest04 {
	public static void main(String[] args) {
	  
	  // 5 + 3 * 7 (전제조건 : 연산자 우선 순위 무시)
		Calculatior04 calc1 = new Calculatior04();
		Calculatior04 calc2 = new Calculatior04();
		
		calc1.init(5);
		calc1.puls(3);
		calc1.multiple(7);
	 
	  
	  System.out.println(calc1.result);
  }
}
