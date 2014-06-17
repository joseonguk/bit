package exam.oop3.step04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* Collertion API
 * - 값 목록을 다루는 객체
 * 
 * Map의 도우미 Iterator 소개
 * - Iterator는 Map의 데이터를 꺼내주는 역할을 한다.
 * - 컬렉션의 종류(List, Set, Map)에 상관없이 일관된 방식으로 데이터를 조회할 수 있다.
 *   hasNext();
 */
public class CollectionTest03 {
  public static void main(String[] args) {
    HashMap map = new HashMap();       // 데이터를 순서에 상관없이 관리한다.
    // 순서가 중요하다면은 set을 쓰면 안됨
    // 순서를 신경쓸거라면 array를 써야됨
    
    map.put("1010", "홍길동");
    map.put("2020", "임꺽정");;
    map.put("3030", "장길산");
    map.put("4040", "장보고");
    
    displayEntryFromMap(map);
    displayKeyFromMap(map);
    displayValuesFromMap(map);
    
   
  }
  
  public static void displayValuesFromMap(HashMap map){
    System.out.println("---------------------------");
    Iterator iterator = map.values().iterator();
    
    String vlaue;
    while(iterator.hasNext()){
      vlaue = (String)iterator.next();
      System.out.println(vlaue);
    }
  }
  
  public static void displayKeyFromMap(HashMap map) {
    
    System.out.println("---------------------------");
    Iterator iterator = map.keySet().iterator();
    
    String key;
    while(iterator.hasNext()){
      key = (String)iterator.next();
      System.out.println(key + " : " + map.get(key));
    }
  }
  
  public static void displayEntryFromMap(HashMap map){
    
    System.out.println("---------------------------");
    //Set set = map.entrySet();
    //Iterator iterator = set.iterator();
    Iterator iterator = map.entrySet().iterator();
    
    Entry entry;
    // 키와 값이 들어 가있는 한쌍을 Entry라고 함
    while(iterator.hasNext()){
      entry = (Entry)iterator.next();
      System.out.println(entry.getKey() +" : " + entry.getValue());
    }
    
  }
}
