package exam.oop3.step01;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class ScoreFrame01 extends Frame{
	
	public ScoreFrame01(){
		this.setLayout(new FlowLayout());
	  this.add(new Label("이름"));
	  this.add(new TextField(20));
	  this.add(new Button("버튼"));
	  
	  this.setTitle("비트 성적관리 시스템");
	  this.setSize(400, 300);
	  this.addWindowListener(new MyWindowListener());
	  //this.setVisible(true);
	}

}
