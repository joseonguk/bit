package exam.basic;

import java.util.Scanner;

public class Control01_t01 {
	public static void main(String[] args) {
		// 문제2) 단, 연산자 조건 검사에 switch문 사용
		// 다음과 같은 동작하도록 코드를 구현하세요
		// 수를 입력하세요? 10
		// 연산자를 입력하세요? (+, -, *, /)
		// 두번째 수를 입력하세요? 2
		// 계산 결과는 5입니다.
		// jdk7이상만 가능함
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요?");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.print("연산자를 입력하세요? (+, -, *, /)");
		String op = sc.nextLine();
		
		System.out.print("두번째 수를 입력하세요?");
		int num1 = Integer.parseInt(sc.nextLine());
		
		int result;
		switch(op){
		case "+":
			result = num + num1;
			break;
		case "-":
			result = num - num1;
			break;
		case "*":
			result = num * num1;
			break;
		case "/":
			result = num / num1;
			break;
		default:
			System.out.println("지원하지 않는 연산자 입니다.");
			return;
		}
		
			System.out.println("계산 결과는"+result+"입니다.");
		
	}
	public static void main03(String[] args) {
		// 문제3) 단, 연산자 조건 검사에 switch문 사용
		// 다음과 같은 동작하도록 코드를 구현하세요
		// 수를 입력하세요? 10
		// 연산자를 입력하세요?(+(0), -(1), *(2), /(3)) 3
		// 두번째 수를 입력하세요? 2
		// 계산 결과는 5입니다.
		
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요?");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.print("연산자를 입력하세요? +(0), -(1), *(2), /(3)");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("두번째 수를 입력하세요?");
		int num2 = Integer.parseInt(sc.nextLine());
		
		int result;
		switch(num1){
		case 0:
			result = num + num2;
			break;
		case 1:
			result = num - num2;
			break;
		case 2:
			result = num * num2;
			break;
		case 3:
			result = num / num2;
			break;
		default:
			System.out.println("지원하지 않는 연산자 입니다.");
			return;
		}
		
			System.out.println("계산 결과는"+result+"입니다.");
		
		
		
	}
	public static void main02(String[] args) {
		// 문제2)
		// 다음과 같은 동작하도록 코드를 구현하세요
		// 수를 입력하세요? 10
		// 연산자를 입력하세요?(+(0), -(1), *(2), /(3)) 3
		// 두번째 수를 입력하세요? 2
		// 계산 결과는 5입니다.
		
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요?");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.print("연산자를 입력하세요? +(0), -(1), *(2), /(3)");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("두번째 수를 입력하세요?");
		int num2 = Integer.parseInt(sc.nextLine());
		
		if (num1 == 0){
			System.out.println("계산 결과는"+ (num+num2)+"입니다.");
		}else if(num1 == 1){
			System.out.println("계산 결과는"+ (num-num2)+"입니다.");
		}else if(num1 == 2){
			System.out.println("계산 결과는"+ (num*num2)+"입니다.");
		}else if(num1 == 3){
			System.out.println("계산 결과는"+ (num/num2)+"입니다.");
		}else {
			System.out.println("지원하지 않는 연산자 입니다.");
		}
		
		
	}
	public static void main01(String[] args) {
		System.out.print("당신의 나이는?");
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		int age = Integer.parseInt(text);
		
		//System.out.println("당신의 나이는 : "+age+ " 입니다.");
		
		//문제1)
		// 7세 이하는 "유아입니다." 출력
		// 8세 이상 ~ 18세 미만 "청소년입니다" 출력
		// 18세 이상 ~ 30세 미만 "청년입니다." 출력
		// 30세 이상 ~ 50세 미만 "장년입니다." 출력
		// 50세 이상 ~ 60세 미만 "중년입니다." 출력
		// 60세 이상 ~ "노인입니다." 출력
		
		
		if(age <= 7){
			System.out.println("유아입니다.");
		}
		else if(age >= 8 && age <18){
			System.out.println("청소년입니다");	
		}
		else if(age >= 18 && age <30){
			System.out.println("청년입니다.");	
		}
		else if(age >= 30 && age <50){
			System.out.println("장년입니다.");	
		}
		else if(age >= 50 && age <60){
			System.out.println("중년입니다.");	
		}
		else {
			System.out.println("노인입니다.");	
		}
	}

}
