/* 함수 => 객체지향에서는 "메서드"라 부른다.
 * - 명령어들을 기능 단위로 묶은 것.
 * - 명령어들을 관리하기 쉽다.
 * - 쉽게 재사용할 수 있다.
 * 
 * - 문법
 * 	 리턴하는데이터의타입 함수명 (값을 받을 변수 선언, ....){ 명령들 }
 * 
 * - 함수에서 값을 받기 위해 선언하는 변수 => parameter
 * 	 int plus(int a, int b) { return a + b }
 * 	 파라미터: a, b
 * 
 * - 함수를 호출할 때 넘겨주는 값 => argument
 * 	 int result = plus(10, 20);
 * 	 아규먼트(인자): 10, 20
 * 
 * - 예1. void, 파라미터 없음.
 * 	 void print() {...}
 * 
 * - 예2. void, 파라미터 잇음.
 * 	 void print(String msg) {...}
 * 
 * - 예3. 리턴 있음. 파라미터 없음
 * 	 String getName() {return "okoko"}
 * 
 * - 예4. 리턴 있음. 파라미터 있음
 * 	 int plus(int a, int b) { return a+b; }
 */
package exam.oop.test;

import java.util.Scanner;

import exam.oop.test_oop.Address;

public class Test01_ex2 {

	public static void main(String[] args) {
		int count = 0;
		
		Address[] ad = new Address[100];

		Scanner sc = new Scanner(System.in);
	
		//Address a;
		for(int i = 0; i < ad.length; i++){
			ad[i] = inputAddress(sc);
		
			count++;
			
			if(!isContinue(sc))
				break;
		}

		for(int i = 0; i < count; i++){
			printAddress(ad[i]);		
		}	
	}
	
	static boolean isContinue(Scanner sc){
		System.out.print("계속 출력 하겟는가? (y/n)");
		if(sc.nextLine().equals("n"))
			return false;
		else
			return true;	
	}
	
	static Address inputAddress(Scanner sc){
		Address a = new Address();
		
		System.out.print("이름?");
		a.name = sc.nextLine();
		
		System.out.print("직위?");
		a.office = sc.nextLine();
		
		System.out.print("전화번호?");
		a.num = Integer.parseInt(sc.nextLine());
		
		System.out.print("이메일?");
		a.e_mail = sc.nextLine();
		
		System.out.print("회사?");
		a.company = sc.nextLine();
		
		return a;
	}
	
	static void printAddress(Address a){
		System.out.println("이름 : "+a.name+
				 " 직위 : "+a.office+
				 " 전화번호 : "+a.num+ 
				 " 이메일 : "+a.e_mail+
				 " 회사 : "+a.company);

	}

}
