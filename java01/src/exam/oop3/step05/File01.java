package exam.oop3.step05;

import java.io.File;
import java.io.IOException;

/* File 클래스 활용
 * 
 */

public class File01 {
  public static void main(String[] args) throws IOException{
   File f = new File("../test.csv");
   
   // exists() 위치에 잇냐없냐 확인
   if(f.exists()) {
     System.out.println("존재한다.");
   }
   
   // 전체경로를 지정할 때 사용// 그냥 그대로의 정체 경로
   System.out.println("getAbsolutePath()" + f.getAbsolutePath());
   
   // ..을 계산해서 실제 경로 출력
   System.out.println("getCanonicalPath()" + f.getCanonicalPath());
   
   // 파일의 이름 출력
   System.out.println("getName()" + f.getName());
   
   // 생성자에 준 path를 말함
   System.out.println("getPath()" + f.getPath());

   File f2 = new File("test2.txt");
   //f2.createNewFile();
   f2.delete();
   
  }
}
