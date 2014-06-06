// 문제)
// 이름, 직위, 전화번호, 이메일, 회사 정보를 입력 받고 출력하는 프로그램을 짜시오
// 단, 새 데이터 타입을 정의해서 값을 입력 받으시오

package exam.oop;

import java.util.Scanner;

// 1. 새 데이터 타입 정의 : Address
/*class Address {
	String name;
	String office;
	int num;
	String e_mail;
	String company;
	
}*/

public class Test01_ex1 {

	public static void main(String[] args) {
		int count = 0;
		
		// 2. Address 레퍼런스 배열 준비
		Address[] ad = new Address[100];
		
		// 3. 키보드 입력 도구 준비
		Scanner sc = new Scanner(System.in);
		
		// 4. 주소 정보 입력 받기
		Address a;
		for(int i = 0; i < ad.length; i++){
			a = new Address();
			
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
			
			count++;
			
			ad[i] = a;
			
			System.out.println("계속 출력 하겟는가? (y/n)");
			if(sc.nextLine().equals("n"))
				break;
			
		}
		
		// 5. 주소 정보 출력 하기
		for(int i = 0; i < count; i++){
			a = ad[i];
			System.out.println("이름 : "+a.name+
												 " 직위 : "+a.office+
												 " 전화번호 : "+a.num+ 
												 " 이메일 : "+a.e_mail+
												 " 회사 : "+a.company);
		}

	}

}
