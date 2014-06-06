package exam.basic;

import java.util.Scanner;

public class Output {
		
	Scanner sc = new Scanner(System.in);
		
	public Output(){
		output();
	}
	
	private void output(){
		for(int i = 0; i<Input.count; i++){
			//System.out.println("홍길동 님의 총점과 평균은 다음과 같습니다.");
			System.out.println(Input.name[i] + " 님의 총점과 평균은 다음과 같습니다. ");
			System.out.println("총점 = "+Input.tot[i]+ ", "+ "평균 = "+Input.aver[i]);	
		}
	}
		
}
