import javax.swing.*;
import java.awt.*;

class afront{
	JFrame f = new JFrame();
	JLabel lb = new JLabel("請選擇結帳、資料、項目、存貨");
        JButton bt = new JButton("結帳");
	JButton bt1 = new JButton("資料");
	JButton bt2 = new JButton("項目");
	JButton bt3 = new JButton("存貨");
	JButton bt4 = new JButton("登出");
	
	ImageIcon lg = new ImageIcon("a1.jpg");
	JLabel lb1 = new JLabel("",lg,JLabel.CENTER);
	
	
	afront(){
		bt.setBounds(60,125,100,150);
		f.add(bt);
		bt1.setBounds(160,125,100,150);
		f.add(bt1);
		bt2.setBounds(260,125,100,150);
		f.add(bt2);
		bt3.setBounds(360,125,100,150);
		f.add(bt3);
		lb.setBounds(200,50,250,50);
		f.add(lb);
		bt4.setBounds(480,250,80,80);
		f.add(bt4);
		
		lg.setImage(lg.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT));
		lb1.setBounds(0,0,600,400);
		f.add(lb1);
		
		f.setLayout(null);
		f.setBounds(200,150,600,400); 
		f.setVisible(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
	
	