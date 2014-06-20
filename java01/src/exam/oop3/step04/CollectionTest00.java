package exam.oop3.step04;

import java.util.ArrayList;

/* Collection API
 * - 값 목록을 다루는 객체
 * 
 * ArrayList 
 * - 인스턴스의 주소들을 배열 형태로 다룬다.
 * - 인덱스로 값을 조회할 수 있다.
 */
public class CollectionTest00 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();       // 데이터를 순서대로 관리한다.
    list.add("홍길동");
    list.add("임꺽정");
    list.add("장길산");
    list.add("장보고");
    
    dispalyList(list);
    
    list.remove(3);
    list.remove(2);
    
    dispalyList(list);
    
    list.add("홍길동");
    list.add("홍길동");
    
    dispalyList(list);
  }
  
  public static void dispalyList(ArrayList list){
    
    System.out.println("---------------------------");
    // 넣을때 형 맞추기
    String value;
    for(int i = 0; i<list.size(); i++){
      value = (String)list.get(i);
      System.out.println(value);
    }
  }
}
