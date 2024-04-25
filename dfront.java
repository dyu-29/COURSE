import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class dfront{
	public static void main(String[] args){
			dfront df = new dfront();
		}
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton bt = new JButton("返回");
	JTextField tf = new JTextField();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();	

	dfront(){
	p.setBounds(10,20,200,250);	
	f.add(p);
	bt.setBounds(60,150,80,80);
	f.add(bt);
	tf.setBounds(50,100,100,40);
	f.add(tf);
	tf1.setBounds(190,100,100,40);
	f.add(tf1);
	tf2.setBounds(330,100,100,40);
	f.add(tf2);

	
	f.setTitle("項目表 ");
	f.setLayout(null);
	f.setBounds(200,150,600,400); 
	f.setVisible(false);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}


}