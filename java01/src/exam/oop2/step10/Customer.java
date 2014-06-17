package exam.oop2.step10;

public class Customer {
	String name;
	String tel;
	String email;
	private int age;
	private float height;
	private float weigth;
	private float 체지방;
	String createdDate;
	String startDate;
	String endDate;

	// 인스턴스 변수에 값을 넣고 빼는 메서드 => 프로퍼티
	// 값을 할당하는 메서드 => setter 메서드 => 셋터
	public void setAge(int age) {
		if (age > 5 && age < 100) {
			this.age = age;
		} else
			this.age = 20;
	}

	// 인스턴스 값을 꺼내는 메서드 => getter 메서드 => 겟터
	public int getAge() {
		return this.age;
	}

	public void setHeight(float height) {
		if (height > 50 && height < 250) {
			this.height = height;
		} else {
			this.height = 175;
		}
	}

	public float getHeight() {
		return this.height;
	}

	public void setWeigth(float weigth) {
		if (weigth > 50 && weigth < 250) {
			this.weigth = weigth;
		} else {
			this.weigth = 70;
		}
	}

	public float getweigth() {
		return this.weigth;
	}
}
