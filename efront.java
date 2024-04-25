import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class efront{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  int sw = (int)screenSize.getWidth();
		  int sh = (int)screenSize.getHeight();
	
	JPanel p3 = new JPanel();
	
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton bt = new JButton();
	JTextField tf = new JTextField();
	JButton[][] bta = new JButton[8][3];
	String[][] btaStr = {{"奶油","吐司","鮪魚"},
			     {"厚片","茶包(葉)","培根"},
			     {"火腿","蛋","起司"},
			     {"生菜","熱狗","肉包"},
			     {"菜包","漢堡","美乃滋"},
			     {"1","2","3"},				
			     {"4","5","6"},
			     {"7","8","9"}};


	efront(){
	p.setBounds(10,20,200,250);	
	f.add(p);
	bt.setBounds(50,850,100,100);
	f.add(bt);
	tf.setBounds(50,800,100,40);
	f.add(tf);
	
	p3.setBounds((int)(sw*0.5),(int)(sh*0.1),(int)(sw*0.5),(int)(sh*0.8));
	p3.setLayout(new GridLayout(4,3,5,5));
	f.add(p3);
	
	for(int i=0; i<bta.length; i++) {
    	 for(int j=0;j<bta[0].length; j++) {
    		 bta[i][j] = new JButton(btaStr[i][j]);
    		 bta[i][j].setBackground(Color.yellow);
    		 //bta[i][j].addActionListener(ClickBtn);
    		 p3.add(bta[i][j]);
    	 }
	}
	f.setTitle("項目 ");
	f.setLayout(null);
	f.setBounds(200,150,600,400); 
	f.setVisible(false);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}


}



//病患清單查詢(plist)程式

class plist{

        JFrame f = new JFrame();
        JLabel[] b = new JLabel[3];
        JTextField[] tf = new JTextField[2];
        JButton[] btn = new JButton[2];

        public plist(){

             b[0] = new JLabel("查詢病患");
             b[0].setBounds(10,30,200,60);
             b[0].setFont(new Font("標楷體",Font.PLAIN,24));
             f.add(b[0]);
      
             b[1] = new JLabel("起始日期");
             b[1].setBounds(10,100,100,50);
             b[1].setFont(new Font("標楷體",Font.PLAIN,20));
             f.add(b[1]);
	     
	     b[2] = new JLabel("迄止日期");
             b[2].setBounds(10,150,100,50);
             b[2].setFont(new Font("標楷體",Font.PLAIN,20));
             f.add(b[2]);

             tf[0] = new JTextField("");
             tf[0].setFont(new Font("標楷體",Font.PLAIN,20));
             tf[0].setBounds(120, 100, 200, 50);
             f.add(tf[0]);

	     tf[1] = new JTextField("");
             tf[1].setFont(new Font("標楷體",Font.PLAIN,20));
             tf[1].setBounds(120, 150, 200, 50);
             f.add(tf[1]);

             btn[0] = new JButton("選");
             btn[0].setFont(new Font("標楷體",Font.PLAIN,20));
             btn[0].addActionListener(ProcessSelectDate);
             btn[0].setBounds(330,100,80,50);
             f.add(btn[0]);

	     btn[1] = new JButton("選");
             btn[1].setFont(new Font("標楷體",Font.PLAIN,20));
             btn[1].addActionListener(ProcessSelectDate);
             btn[1].setBounds(330,150,80,50);
             f.add(btn[1]);
        
             f.setLayout(null);
             f.setBounds(100,100,1000,800);
             f.setVisible(true);
             f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }

       //[清空]的事件傾聽器程式
       public ActionListener ProcessSelectDate = new ActionListener(){
           public void actionPerformed(ActionEvent e){

                   if( e.getSource() == btn[0] ){   //選起始日期按鈕

                      DatePopup dp1 = new DatePopup(tf[0]);
                      dp1.showDialog();

                   }

                   if( e.getSource() == btn[1] ){   //選迄止日期按鈕

                      DatePopup dp2 = new DatePopup(tf[1]);
                      dp2.showDialog();//自行撰寫

                   }
                      

          }
       };

}