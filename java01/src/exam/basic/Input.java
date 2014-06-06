package exam.basic;

import java.util.Scanner;

public class Input {
	static String[] name = new String[100];
	static int[] kor = new int[100];
	static int[] eng = new int[100];
	static int[] math = new int[100];
	static int[] tot = new int[100];
	static float[] aver = new float[100];
	static int count = 0;
	
	Scanner sc = new Scanner(System.in);
	
	public Input(){
		input();
	}
	
	private void input(){
		for(int i = 0; i<name.length; i++){
			System.out.print("이름?");
			name[i] = sc.nextLine();
			
			System.out.print("국어?");
			kor[i] = Integer.parseInt(sc.nextLine());
			
			System.out.print("영어?");
			eng[i] = Integer.parseInt(sc.nextLine());
			
			System.out.print("수학?");
			math[i] = Integer.parseInt(sc.nextLine());
			
			tot[i] = kor[i] + eng[i] + math[i];
			aver[i] = tot[i] / 3.0f;
			
			count++;
			
			System.out.print("계속 등록하시겠습니까?(y/n)");
			if(sc.nextLine().equals("n"))
				break;
		}
	}
}
