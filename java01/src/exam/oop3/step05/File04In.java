package exam.oop3.step05;

import java.io.FileReader;
import java.io.IOException;

/* FileReader
 * - 문자 데이터를 읽을 때 사용하는 클래스
 */

public class File04In {
  public static void main(String[] args) throws IOException {
    FileReader in = new FileReader("File04.txt");
    
    char[] buf = new char[100];
    int readSize = 0;
    // 3번부터 5개까지(0번부터시작)
    readSize = in.read(buf, 3, 5);
    System.out.print(buf);
    //System.out.println(buf[13]);
    
    in.close();
  }
  
  
  public static void main01(String[] args) throws IOException {
    FileReader in = new FileReader("File04.txt");
    
    System.out.println((char)in.read());
    System.out.println((char)in.read());
    // in.reset();
    
    char[] buf = new char[4];
    int readSize = 0;
    readSize = in.read(buf);
    System.out.print(buf);
    System.out.println("," + readSize);
    
    readSize = in.read(buf);
    System.out.print(buf);
    System.out.println("," + readSize);
    
    readSize = in.read(buf);
    System.out.print(buf);
    System.out.println("," + readSize);
    
    readSize = in.read(buf);
    System.out.print(buf);
    System.out.println("," + readSize);
    
    in.close();
  }
}
