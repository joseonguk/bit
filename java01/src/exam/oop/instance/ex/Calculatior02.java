package exam.oop.instance.ex;

public class Calculatior02 {
	
	static int result;
	
	public static void init(int value){
		Calculatior02.result = value;
	}
	
	public static void puls(int value){
		Calculatior02.result += value;
	}
	
	public static void minus(int value) {
		Calculatior02.result -= value;
	}
	
	public static void multiple(int value) {
		Calculatior02.result *= value;
	}
	
	public static void divide(int value) {
		Calculatior02.result /= value;
	}
}
