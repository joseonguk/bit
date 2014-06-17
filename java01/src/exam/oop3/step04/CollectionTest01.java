package exam.oop3.step04;

import java.util.ArrayList;
import java.util.HashSet;

/* Collertion API
 * - 값 목록을 다루는 객체
 * 
 * HashSet 
 * - 인스턴스의 주소들을 배열 형태로 다룬다.
 * - 인덱스로 값을 조회할 수 있다.
 * - 인스턴스를 중복 저장하지 않는다.
 */
public class CollectionTest01 {
  public static void main(String[] args) {
    HashSet list = new HashSet();       // 데이터를 순서에 상관없이 관리한다.
    // 순서가 중요하다면은 set을 쓰면 안됨
    // 순서를 신경쓸거라면 array를 써야됨
    
    list.add("홍길동");
    list.add("임꺽정");
    list.add("장길산");
    list.add("장보고");
    
    dispalyList(list);
    
    list.remove("장보고");
    list.remove("장길산");
    
    dispalyList(list);
    
    list.add("홍길동");    // set은 데이터 중복을 허용하지 않는다.
    list.add("홍길동");
    
    dispalyList(list);
  }
  
  public static void dispalyList(HashSet set){
    
    System.out.println("---------------------------");
    // 넣을때 형 맞추기
    String value;
    Object[] list = set.toArray();
    // HashSet은 get이 없음 그러므로 배열을 만들어서 받아옴
    for(int i = 0; i<list.length; i++){
      value = (String)list[i];
      System.out.println(value);
    }
  }
}
