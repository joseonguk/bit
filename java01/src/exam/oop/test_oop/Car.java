package exam.oop.test_oop;

public class Car {
	// 공통 데이터
	static int count;
	
	// 클래스 변수 초기화  => 스태틱 블록
	static {
		count = 100;
	}
	
	// 개별 데이터 => 인스턴스 변수
	public int serialNo;
	public String model;
	public String carNo;
	public int cc;
	public int weight;
	public int capacity;
	
	// 인스턴스 변수 초기화  -> 생성자
	public Car(String model, String carNo) {
		this.serialNo = ++/*Car.*/count;
		this.model = model;
		this.carNo = carNo;
	}
}
