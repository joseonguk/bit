package exam.oop3.step03;

/* 성적 등록 폼 만들기
 * - panel 사용
 *   > 여러 개의 UI 컴포넌트를 묶을 때 사용하는 윈도우
 */

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScoreFrame_01 extends Frame{
  
	public ScoreFrame_01(){
	  
    this.setTitle("비트 성적관리 시스템");
    this.setSize(200, 300);
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.out.println("windowClosing");
        System.exit(0);
      }
    });
    
	  this.setLayout(new FlowLayout(FlowLayout.LEFT));
	  
	  Panel p1 = new Panel();
	  Panel p2 = new Panel();
	  Panel p3 = new Panel();
	  Panel p4 = new Panel();
    
    Label label = new Label("이름");
    p1.add(label);
    
    final TextField tf = new TextField(10);
    p1.add(tf);
    
    Label label1 = new Label("국어");
    p2.add(label1);
    
    
    
    Label label2 = new Label("영어");
    p3.add(label2);
    
    Label label3 = new Label("수학");
    p4.add(label3);

    
    
    final TextField tf1 = new TextField(5);
    p2.add(tf1);
    
    final TextField tf2 = new TextField(5);
    p3.add(tf2);
    
    final TextField tf3 = new TextField(5);
    p4.add(tf3);
	  
    this.add(p1);
    this.add(p2);
    this.add(p3);
    this.add(p4);
    
	  Button btn = new Button("추가");
    btn.setPreferredSize(new Dimension(80, 40));
    btn.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        // 과제
        System.out.println("name = "+tf.getText());
        System.out.println("kor = " +tf1.getText());
        System.out.println("eng = " +tf2.getText());
        System.out.println("math = " +tf3.getText());
      }
    });
    this.add(btn);
    
	}
}
