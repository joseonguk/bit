package exam.oop.instance.ex;

public class Calculatior03 {
	
	int result;
	
	public static void init(Calculatior03 that, int value){
		that.result = value;
	}
	
	public static void puls(Calculatior03 that, int value){
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
