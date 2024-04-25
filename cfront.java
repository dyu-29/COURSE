import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class cfront{
	JFrame f = new JFrame();
    JTextField tf = new JTextField("");
	
 	JTabbedPane tbp = new JTabbedPane();
	JPanel[] p = new JPanel[3];
	JLabel[] b = new JLabel[3];
	
	String[] title = {"品項","單價","數量","小計"};
	String[][] data = new String[30][4];
	JTable table = new JTable(data,title);
	JScrollPane sp = new JScrollPane(table,
			ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			
	JButton bt = new JButton("牛肉麵");
	JButton bt1 = new JButton("鍋貼");
	JButton bt2 = new JButton("咖啡");
	
	JButton bt6 = new JButton("咖哩飯");
	JButton bt7 = new JButton("玉米濃湯");
	JButton bt8 = new JButton("麥當勞");
	
	JButton bt3 = new JButton("返回");
	JButton bt4 = new JButton("結帳");
	JButton bt5 = new JButton("清空");

	
	
	int index = 0;
	
	cfront(){	
		
		p[0] = new JPanel();
		p[0].setLayout(null);
		b[0] = new JLabel("義廚");
		b[0].setBounds(100,100,200,50);
		bt.setBounds(30,50,150,50);
		bt.addActionListener(ClickBtn);
		p[0].add(bt);
		
		bt6.setBounds(180,50,150,50);
		bt6.addActionListener(ClickBtn);
		p[0].add(bt6);
		

		p[1] = new JPanel();
		p[1].setLayout(null);
		b[1] = new JLabel("美食街");
		b[1].setBounds(100,50,200,50);
		bt1.setBounds(30,50,150,50);
		bt1.addActionListener(ClickBtn1);
		p[1].add(bt1);

		bt7.setBounds(180,50,150,50);
		bt7.addActionListener(ClickBtn1);
		p[1].add(bt7);
		
		
		p[2] = new JPanel();
		p[2].setLayout(null);
		b[2] = new JLabel("MALL");
		b[2].setBounds(100,50,200,50);
		bt2.setBounds(30,50,150,50);
		bt2.addActionListener(ClickBtn2);
		p[2].add(bt2);
		
		bt8.setBounds(180,50,150,50);
		bt8.addActionListener(ClickBtn2);
		p[2].add(bt8);
		
		
		
		tbp.setBounds(500,10,450,700);
		tbp.addTab("義廚",p[0]);
		tbp.addTab("美食街",p[1]);
		tbp.addTab("MALL",p[2]);
		tbp.setFont(new Font("標楷體",Font.BOLD,20));
		f.add(tbp); 

		sp.setBounds(0,0,300,350);
		sp.setVisible(true);
		f.add(sp);
			
		table.setEnabled(false);
		table.setRowHeight(30);
			
		bt3.setBounds(20,500,200,50);
		f.add(bt3);
		
		
		tf.setBounds(50,350,300,50);
		f.add(tf);
		
		
		bt4.setBounds(20,430,100,50);
		bt4.addActionListener(ClickBtn3);
		f.add(bt4);
		
		bt5.setBounds(140,430,100,50);
		bt5.addActionListener(ClickBtn3);
		f.add(bt5);
		
		
		f.setLayout(null);
		f.setBounds(50,50,900,600); 
		f.setVisible(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public ActionListener ClickBtn = new ActionListener(){ //第1頁，食物:1
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==bt){
				table.setValueAt(bt.getText(),index, 0);
				table.setValueAt("1",index, 2);
				table.setValueAt("100",index, 1);
				table.setValueAt("100",index, 3);
				index++;
			
			}
			if(e.getSource()==bt6){
				table.setValueAt(bt6.getText(),index, 0);  //第1頁，食物:2
				table.setValueAt("1",index, 2);
				table.setValueAt("120",index, 1);
				table.setValueAt("120",index, 3);
				index++;
			
			}
			
		}
	};
	
		public ActionListener ClickBtn1 = new ActionListener(){  //第2頁，食物:1
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==bt1){
				table.setValueAt(bt1.getText(),index, 0);
				table.setValueAt("1",index, 2);
				table.setValueAt("130",index, 1);
				table.setValueAt("130",index, 3);
				index++;
			}
			if(e.getSource()==bt7){
				table.setValueAt(bt7.getText(),index, 0);   //第2頁，食物:2
				table.setValueAt("1",index, 2);
				table.setValueAt("140",index, 1);
				table.setValueAt("140",index, 3);
				index++;
			}
			
		}
		};
		
		public ActionListener ClickBtn2 = new ActionListener(){  //第3頁，食物:1
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==bt2){
				table.setValueAt(bt2.getText(),index, 0);
				table.setValueAt("1",index, 2);
				table.setValueAt("150",index, 1);
				table.setValueAt("150",index, 3);
				index++;
			
			}
			if(e.getSource()==bt8){
				table.setValueAt(bt8.getText(),index, 0);   //第3頁，食物:2
				table.setValueAt("1",index, 2);
				table.setValueAt("90",index, 1);
				table.setValueAt("90",index, 3);
				index++;
			
			}
			
		}
	};
	
	public ActionListener ClickBtn3 = new ActionListener(){  //結帳
		public void actionPerformed(ActionEvent e){
			int price, amount, total, all=0, aa;
			String totalStr;
			if(e.getSource()==bt4){
			for(int i=0;i<index;i++) {
					total = Integer.parseInt((String)table.getValueAt(i,3));
					all=all+total;
				}
				totalStr = String.valueOf(all);
				aa=index*10;
				
				tf.setText("總金額: "+totalStr+"紅利點數"+aa);
				
			}
			if(e.getSource()==bt5){                           //清空
				for(int i=0; i<=index; i++){
				for(int j=0;j<4; j++){
				table.setValueAt("",i, j);
				}
				}
				index = 0;
				tf.setText("");
			}
			
			
		}
	};
}
