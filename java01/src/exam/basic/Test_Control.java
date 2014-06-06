package exam.basic;

public class Test_Control {
	public static void main(String[] args) {
	  //1. for문 문법을 작성하시오.     a     
		/*for(              ){
			...............
		}
		a. 초기값; 조건식; 증감식
		b. 조건식; 초기값; 증감식
		c. 증감식; 초기값; 조건식
		d. 초기값; 증감식; 조건식
		
		*/
		//2. 다음 중 배열의 선언이 틀린것은?    b
		/*a. int a[] = {1, 2, 3, 4};
		b. int a[5];
		c. a = new int[5];
		d. a[3]=5;
		*/
		
		//3.다음 문제의 출력값을 구하시오.      d
		/*int i[] = {10, 20, 30, 40};
		System.out.println(i[3]);
		
		a. 10
		b. 20
		c. 30
		d. 40
		*/
		
		//4. 다음 보기중 맞는 답은 무엇인가?     a   
		/*int i[] = new int[5];
		
		a. i[4]는 0값을 가짐
		b. i[5]는 0값을 가짐
		c. i[0]은 null값을 가짐
		d. i[4]는 null값을 가짐
		*/
		
		//5. 다음중 맞는 답을 고르시오.         c     
	/*	for(int i= 1; i<2; i++);{
			System.out.println(i);
		}
		
		a. 1
		b. 2
		c. 실행 안됨
		d. 1과 2가 출력
		*/
		
		//6. 다음 switch-case문을 보고 맞는 답을 고르시오.   d  
		/*int score = 76;
		
		switch(score / 10){
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7
			System.out.println("C");
			break;
		default:
			System.out.println("F");
		}
		
		a. A 
		b. B
		c. C
		d. 실행 안됨
		*/
		
		//7. 다음 if문을 보고 답을 고르시오.       a
		/*	int i = 5;
		if (i % 2 != 0){
			System.out.println("홀수 출력");
		}else{
			System.out.println("짝수 출력");
		}
		
		a. 홀수 출력
		b. 짝수 출력
		c. 실행 안됨
		*/
		
		//8. 다음 do-while문의 결과값을 찾아라.    a
		/*int a = 2;
		do{
			System.out.println(a);
			a++;
		}while (a < 2);
			
		
		a. 2
		b. 출력 안됨
		c. 실행 안됨
		*/
		
		//9. 다음 while문의 실행 결과를 구하여라     c
		/*int a = 0;
		while(true) 
		{
			if(a < 10)
			{
				a++;
				continue;
			}
			System.out.println(a);
		}
		
		a. 1부터 10까지 출력됨
		b. 실행 안됨
		c. 무한으로 계속 실행
		*/
		
		
		//10. 다음 문제의 답을 구하시오.           b
		/*int [] a = {1,2,3,4,5};
		for (int i = 0; i < a.length; i++) {
		a[i] = a[i]*2;
		System.out.print(a[i]+ " ");
		}
		
		a. 1 2 3 4 5 출력
		b. 2 4 6 8 10 출력
		c. 1 3 5 7 9 출력
		d. 실행 안됨
		*/
		
		
		//11. 다음 if문의 결과값이 나오게 작성하시오
		/*int n = 10;
		if(n % 2){
			System.out.println("짝수입니다.");
		}
		
		if(n % 2 == 0)
		*/
		
		//12. 다음 if문의 출력값을 적어라.
		/*int n = 15;
		if(n < 15){
			System.out.println("15보다 작다");
		}
		if (n == 15){
			System.out.println("15 이다");
		}
		else {
			System.out.println("15보다 크다");
		}
		
		15 이다
				
		*/
		
		
		//13. 다음 for문은 문법적으로 오류가 있다. 어떻게 수정하면 출력이 되겟는가?
		/*for(int j = 0; j < 5; j++)
		{
			j += j;
			
		}
		
		System.out.println(j);
		
		System.out.println(j); 이 부분이 for문안으로 보내야 한다
		
		*/
		
		
		
		
		//14. 다음 for문의 출력값을 구하시오
		/*for(int i = 0; i < 5; i++)
		 	{
				for(int j = 0; j <= i; j++)
				{
					System.out.print("*");
				}
				System.out.println();
			}
		
		*
		**
		***
		****
		*****
	
		*/
		
		//15. 다음 for문의 출력값을 구하시오.
		/*for(int i = 14; i > 0; i--) {
			if(i == 13)
				break;
			System.out.println("i = " + i);
		}
		
		
		i = 14
		
		
		*/
		
		//16. 다음 while문의 출력 값을 구하여라.
		
		/*int a = 0;
		while(a < 5) {
			if((a % 2) == 0){
				a++;
				continue;
			}
			System.out.println("a = " + a);
			a++;
		}
		
		
		a = 1
		a = 3
		
		
		*/
		//17.다음 whil문의 출력값을 구하여라.
		/*int a = 0;
		while(a < 10) 
		{
			if((a % 2) != 0)
			{
				a++;
				break;
			}
			System.out.println("a = " + a);
			a++;
		}
		
		a = 0
		
		*/
		
		
		
		//18. 다음 for문의 출력을 적어라? 
		/*for(int i = 0; i < 3; i++)
		 	{
				for(int j = 0; j < i; j++)
				{
					System.out.print(" ");
				}
				for(int j = 3; j > i; j--)
				{
					System.out.print("*");
				}
				for(int j = 2; j > i; j--)
				{
					System.out.print("*");
				}
				System.out.println();
			}
		
		
		
		 *****
		 	***
		 	 *
		  
		  
		  */
		
		//19. 다음 switch-case 문의 출력 결과를 나타내시오
		/*int score = 76;
		
		switch(score / 10){
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("F");
		}
		
		C
		
		
		*/
		
		//20. 다음 배열의 출력값을 구하여라.
		/*int i[] = {10, 20, 30, 40, 50};
		for(int j = 0; j < i.length; j++){
			System.out.print(i[j]+" ");
		}
		
		10 20 30 40 50
		
		
		*/

		
	 

		
		
  }
}
