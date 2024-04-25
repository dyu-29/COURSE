import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class cpos{
	clogin login = new clogin();
	cfront front = new cfront();
	afront front1 = new afront();
	bfront front2 = new bfront();
	dfront front3 = new dfront();
	efront front4 = new efront();
	
	
	cpos(){
		login.bt[1].addActionListener(ClickLogin);
		front.bt3.addActionListener(ClickLogin1);
		front1.bt.addActionListener(ClickLogin2);
		front1.bt1.addActionListener(ClickLogin3);
		front2.bt.addActionListener(ClickLogin4);
		front1.bt4.addActionListener(ClickLogin5);
		front1.bt3.addActionListener(ClickLogin6);
		front3.bt.addActionListener(ClickLogin7);
		front4.bt.addActionListener(ClickLogin8);
		front1.bt2.addActionListener(ClickLogin9);
		
	}
	public ActionListener ClickLogin = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String acnt = login.tf.getText();
			String pwd = login.pf.getText();
			if( acnt.equals("test") && pwd.equals("123") ){
			       login.f.setVisible(false);
				   front1.f.setVisible(true);
				   login.b[1].setText("");
			} else {
				   login.tf.setText("");
				   login.pf.setText("");
				   login.b[1].setText(" b   K X   ~");
			}
		}
	};
		public ActionListener ClickLogin1 = new ActionListener(){
		public void actionPerformed(ActionEvent e){	
		front1.f.setVisible(true);
		front.f.setVisible(false);
		}
		};
		
		public ActionListener ClickLogin2 = new ActionListener(){
		public void actionPerformed(ActionEvent e){
		front1.f.setVisible(false);
		front.f.setVisible(true);	
		}
		};
		
		public ActionListener ClickLogin3 = new ActionListener(){
		public void actionPerformed(ActionEvent e){
		front1.f.setVisible(false);
		front2.setVisible(true);	
		}
		};
		
		public ActionListener ClickLogin4 = new ActionListener(){
		public void actionPerformed(ActionEvent e){
		front1.f.setVisible(true);
		front2.setVisible(false);	
		}
		};
		
		public ActionListener ClickLogin5 = new ActionListener(){
		public void actionPerformed(ActionEvent e){
		front1.f.setVisible(false);
		login.f.setVisible(true);
		login.tf.setText("");
		login.pf.setText("");
		}
		};
		
		
		public ActionListener ClickLogin6 = new ActionListener(){     
		public void actionPerformed(ActionEvent e){
		front1.f.setVisible(false);
		front3.f.setVisible(true);	
		}
		};
		
		public ActionListener ClickLogin7 = new ActionListener(){
		public void actionPerformed(ActionEvent e){
		front1.f.setVisible(true);
		front3.f.setVisible(false);	
		}
		};
		
		public ActionListener ClickLogin8 = new ActionListener(){
		public void actionPerformed(ActionEvent e){
		front1.f.setVisible(true);
		front4.f.setVisible(false);	
		}
		};

		public ActionListener ClickLogin9 = new ActionListener(){
		public void actionPerformed(ActionEvent e){
		front1.f.setVisible(false);
		front4.f.setVisible(true);	
		}
		};
}


