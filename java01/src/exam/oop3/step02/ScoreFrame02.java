package exam.oop3.step02;

/* 이벤트 리스너를 inner class로 만들기
 * - member inner class
 *  > 바깥 클래스를 통해서 접근할 수 없다.
 *  > 인스턴스를 통해서 접근 가능
 */

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScoreFrame02 extends Frame{
	
  //member inner 클래스
  class MyWindowListener3 extends WindowAdapter{

    public void windowClosing(WindowEvent e) {
      System.out.println("windowClosing");
      System.exit(0);
    }
  }
  
  
  
	public ScoreFrame02(){
	  
	  this.setLayout(new FlowLayout());
	  
	  Label label = new Label("이름");
	  // FlowLayout에서는 각 UI 컴포넌트의 x, y 좌표의 width, height를 무시한다.
	  // FlowLayout에서 UI 컴포넌트의 크기를 설정하고 싶다면, 
	  // 다음과 같이 PreferredSize를 설정해야 한다.
	  label.setPreferredSize(new Dimension(50, 40));
	  this.add(label);

	  TextField tf = new TextField(20);
	  //tf.setBounds(70, 40, 80, 25);
	  tf.setPreferredSize(new Dimension(100, 40));
	  this.add(tf);
	  
	  Button btn = new Button("추가");
    //btn.setBounds(20, 80, 60, 25);
    btn.setPreferredSize(new Dimension(80, 40));
    this.add(btn);
	  
	  this.setTitle("비트 성적관리 시스템");
	  this.setSize(400, 300);
	  this.addWindowListener(new MyWindowListener3());
	  //this.setVisible(true);
	}

}
