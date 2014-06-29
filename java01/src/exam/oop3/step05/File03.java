package exam.oop3.step05;

import java.io.File;
import java.io.FilenameFilter;
import java.io.FileFilter;
import java.io.IOException;

/* 문제: c:/javaide의 모든 폴더을 출력하시오.
 * - 그 하위 폴더도 포함한다. 
 * 
 * 문제 : 폴더를 출력할 때 다음 형식으로 출력하시오.
 * - c:/javaide
 *   c:/javaide/server
 *   c:/javaide/server/tomcat....
 */


public class File03 {

  public static void main(String[] args) {
    File f = new File("c:/javaide/server");
    
    dispalyDirect(f);
    
    dispalyDirectory(f);
    
   /* 
    try {
      display("c:/javaide");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }*/
  }
  
  
  public static void display(String source) throws IOException {
    File dir = new File(source);
    for(File f : dir.listFiles()){
      if (f.isDirectory()){
        System.out.println(f.getAbsolutePath());
        display(f.getCanonicalPath().toString());
      }
    }
  }
  
  
  
  
  // 디렉토리에 들어있는 모든 하위 데렉토리를 출력한다.
  static void dispalyDirectory(File dir){
    
    for (File file : dir.listFiles()) {
      if (file.isDirectory()){
        System.out.println(file.getAbsolutePath());
        dispalyDirectory(file);
      }
     
    }
  }
    
    static void dispalyDirect(File dir){
      
      for (File file : dir.listFiles()) {
        if (file.isDirectory()){
          System.out.println(file.getName());
          dispalyDirectory(file);
        }
       
      }
    
    
  }
}
