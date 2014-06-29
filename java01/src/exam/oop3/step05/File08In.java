package exam.oop3.step05;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class File08In {
  
  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("file08.dat");
    ObjectInputStream in2 = new ObjectInputStream(in);
    
    Score score = (Score)in2.readObject();
    
    //score.compute();
    
    in2.close();
    in.close();
    
    System.out.println(score.getName());
    System.out.println(score.getKor());
    System.out.println(score.getEng());
    System.out.println(score.getMath());
    // score.compute(); 이부분을 사용하지 않으면 0으로 출력
    System.out.println(score.getTotal());
    System.out.println(score.getAverage());
    
  }
}
