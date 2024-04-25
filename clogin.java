import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class clogin{
	
	JFrame f = new JFrame();
	JLabel[] b = new JLabel[4];
    JTextField tf = new JTextField();
    JPasswordField pf = new JPasswordField();
    JButton[] bt = new JButton[2];	
	ImageIcon logo = new ImageIcon("昱儒科技3.png");
	JLabel label = new JLabel(logo, JLabel.CENTER);
	Color co = new Color(130,130,230);
	Container c =f.getContentPane();
	
	clogin(){
		
		c.setBackground(co);
		
		label.setBounds(180,10,100,100);
		f.add(label);
		
		b[0] = new JLabel("POS System");
		b[0].setBounds(340,50,200,40);
		f.add(b[0]);
		
		b[1] = new JLabel("");
		b[1].setBounds(200,50,200,40);
		f.add(b[1]);
		
		b[2] = new JLabel("帳號");
		b[2].setBounds(200,120,100,40);
		f.add(b[2]);
		
		tf.setBounds(250,120,200,40);
		f.add(tf);
		
		b[3] = new JLabel("密碼");
		b[3].setBounds(200,200,100,40);
		f.add(b[3]);
		
		pf.setBounds(250,200,200,40);
		f.add(pf);
		
		bt[0] = new JButton("取消");
		bt[0].setBounds(200,270,100,40);
		bt[0].addActionListener(ClickBtn1);
		f.add(bt[0]);
		
		bt[1] = new JButton("登入");
		bt[1].setBounds(320,270,100,40);
		f.add(bt[1]); 
		
		f.setLayout(null);
		f.setBounds(200,150,600,400); 
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public ActionListener ClickBtn1 = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tf.setText("");
			pf.setText("");
			b[1].setText(""); 
		}
	};
}

