package util;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MyHttpClient {
  public static void main(String[] args) throws Exception{
    Socket socket = new Socket("www.naver.com", 80);
    
    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());
    
    // 요청라인(request line)
    // GET 이부분을 요청 메서드라고함(명령어)
    out.println("GET / HTTP/1.1");          // /이거 밑에 잇는거 찾음
    out.println("Host: www.naver.com");     // 무조건 host를 줘야함
    out.println();
    
    String line = null;
    while(true) {
      line = in.nextLine();
      System.out.println(line);
      if(line.equals("")){
        break;
      }
    }    
    
    while(true){
      try {
        System.out.println(in.next());
      } catch(Exception e){
        break;
      }
    }
    
    
    out.close();
    in.close();
    socket.close();
  }
}
