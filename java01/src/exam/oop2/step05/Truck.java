package exam.oop2.step05;

public class Truck extends Car {
	int weight = 1000;		//중량
	
	public Truck(int weight) {
		
		//super();
		super("오호라");		// 수퍼클래스의 생성자 중에서 호출될 생성자를 선택할 수 있다.
		System.out.println("Truck()");
		this.weight = weight;
	}
}
