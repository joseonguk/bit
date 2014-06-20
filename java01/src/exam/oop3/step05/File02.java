package exam.oop3.step05;

import java.io.File;
import java.io.FilenameFilter;
import java.io.FileFilter;

/* 디렉토리 다루기 */

public class File02 {

  public static void main(String[] args) {
    File f = new File("c:\\");
    
    if (f.isDirectory()){
      System.out.println("디렉토리다.");
    }
    
    System.out.println("-------디렉토리와 파일을 모두 출력-------");
    for(String name :f.list()) {
      System.out.println(name);
    }
    
    
    
    /*
    System.out.println("-----------디렉토리만 출력-----------");
    class DirectoryFilter implements FilenameFilter {

      public boolean accept(File dir, String name) {
        
        //System.out.println(dir.getAbsolutePath() + "\\" + name);
        //File f = new File(dir.getAbsolutePath() + "\\" + name);
        //File f = new File(dir, name);
        //f.isDirectory();
        
        if(new File(dir, name).isDirectory()){ return true; } 
        else {return false; }
      }
      
    }
    for (String name : f.list(new DirectoryFilter())) {
      System.out.println(name);
    }
    */
    System.out.println("---------(실무)디렉토리만 출력---------");
    for (String name : f.list(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        if(new File(dir, name).isDirectory()){ return true; } 
        else {return false; }
      }
    })) {
      System.out.println(name);
    }
    
    System.out.println("---listFile() 사용 : 디렉토리 + 파일---");
    for (File file : f.listFiles()) {
      System.out.println(file.getName());
    }
    
    System.out.println("------listFile() 사용 : 디렉토리------");
    for (File file : f.listFiles()) {
      if (file.isDirectory()){
        System.out.println(file.getName());
      }
    }
    
    System.out.println("----listFile() 필터 사용 : 디렉토리----");
    for (File file : f.listFiles(new FileFilter() {
      public boolean accept(File pathname) {
        return pathname.isDirectory();
      }
    })) {
      System.out.println(file.getName());
    }
  }
}
