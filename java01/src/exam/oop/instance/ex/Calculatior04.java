package exam.oop.instance.ex;

public class Calculatior04 {
	
	int result;
	
	public void init(int value){
		this.result = value;
	}
	
	public void puls(int value){
		this.result += value;
	}
	
	public void minus(int value) {
		this.result -= value;
	}
	
	public void multiple(int value) {
		this.result *= value;
	}
	
	public void divide(int value) {
		this.result /= value;
	}
}
