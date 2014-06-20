package exam.oop3.step05;

import java.io.FileWriter;
/*FileWriter
 * - 문자 데이터를 출력할 때 사용하는 클래스
 */
import java.io.IOException;

public class File04Out {
  public static void main(String[] args) throws IOException {
    FileWriter out = new FileWriter("File04.txt");
    out.write('가');
    out.write('A');
    
    
    out.write(new char[] {'가', '나', 'A', 'B'});
    out.write(new String("가나다ABC123"));
    
    out.close();
  }
}
