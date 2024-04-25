
 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;
 import java.awt.Toolkit;
 import java.awt.Dimension;


 
 //人機互動層類別
 //CHCI_frame: Class HumanComputerInteraction_frame (人機介面-框架類別)

 class CHCI_login extends JFrame{      //系統的視窗
                JLabel b = new JLabel("學生資料管理系統",JLabel.CENTER);
		JLabel b1 = new JLabel("帳號");
		JLabel b2 = new JLabel("密碼");
                JLabel b3 = new JLabel("",JLabel.CENTER);
		JTextField tf = new JTextField("");
		JPasswordField t2 = new JPasswordField("");
		
		JButton bt = new JButton("登入");
		JButton bt1 = new JButton("清除");

     //建構子:類別CHCI_frame
     public CHCI_login(){
       
         Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                int height =(int)screenSize.height;
                int width = (int)screenSize.width;

	 Font font1 = new Font("標楷體",Font.BOLD,30);
		

                b.setBounds((int) (screenSize.getWidth()*0), (int) (screenSize.getHeight()*0), (int) (screenSize.getWidth()*0.6), (int) (screenSize.getHeight()*0.2));
		b.setFont(font1);
		add(b);
                
		b1.setBounds((int) (screenSize.getWidth()*0.15), (int) (screenSize.getHeight()*0.12), (int) (screenSize.getWidth()*0.2), (int) (screenSize.getHeight()*0.2));
		b1.setFont(font1);
		add(b1);
		
		b2.setBounds((int) (screenSize.getWidth()*0.15), (int) (screenSize.getHeight()*0.22), (int) (screenSize.getWidth()*0.2), (int) (screenSize.getHeight()*0.2));
		b2.setFont(font1);
		add(b2);

                b3.setBounds((int) (screenSize.getWidth()*0.18),(int) (screenSize.getHeight()*0.05),(int) (screenSize.getWidth()*0.2),(int) (screenSize.getHeight()*0.2));
		b3.setFont(font1);
		add(b3);
		
		tf.setBounds((int) (screenSize.getWidth()*0.2), (int) (screenSize.getHeight()*0.2), (int) (screenSize.getWidth()*0.2), (int) (screenSize.getHeight()*0.05));
		tf.setEnabled(true);
		tf.setFont(font1);
		add(tf);
		
		t2.setBounds((int) (screenSize.getWidth()*0.2), (int) (screenSize.getHeight()*0.3), (int) (screenSize.getWidth()*0.2), (int) (screenSize.getHeight()*0.05));
		t2.setEditable(true);
		t2.setFont(font1);
		add(t2);
		
		bt.setBounds((int) (screenSize.getWidth()*0.1), (int) (screenSize.getHeight()*0.4), (int) (screenSize.getWidth()*0.1), (int) (screenSize.getHeight()*0.05));
                //bt.addActionListener(ClickBtn);
		bt.setEnabled(true);
		bt.setBackground(Color.cyan);
		bt.setFont(font1);
		add(bt);
		
		bt1.setBounds((int) (screenSize.getWidth()*0.4), (int) (screenSize.getHeight()*0.4), (int) (screenSize.getWidth()*0.1), (int) (screenSize.getHeight()*0.05));
                bt1.addActionListener(ClickBtn1);
		bt1.setEnabled(true);
		bt1.setBackground(Color.CYAN);
		bt1.setFont(font1);
		add(bt1);

         //系統視窗的基本設定
         setTitle("學生資料管理系統-Student Management System (SMS)");
         setBounds(0,0, width, height);
         setLayout(null);
         setVisible(true);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


     }

         public ActionListener ClickBtn= new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			  
		    
			  }
			   };
         

         public void clearPane(){
         tf.setText("");
	 t2.setText("");
}

         public ActionListener ClickBtn1= new ActionListener() {
			  public void actionPerformed(ActionEvent e1) {
			  clearPane();
		    
			  }
			   };
         

 } //end for: class CHCI_frame

 
 