
 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 //人機互動層類別
 //CHCI_QR_panel: Class HumanComputerInteraction_QueRy_panel (人機介面-[查詢學生資料]操作畫面類別)

 class CHCI_QR_panel extends JPanel{

     JLabel tLabel = new JLabel("請輸入欲查詢的學生姓名");
     JLabel nLabel = new JLabel("學生姓名");
     JLabel cLabel = new JLabel("查得學號");
     JLabel eLabel = new JLabel("查得電話");
     JLabel mLabel = new JLabel("查得在校成績");

     JTextField nTxtFd = new JTextField("");
     JTextField cTxtFd = new JTextField("");
     JTextField eTxtFd = new JTextField("");
     JTextField mTxtFd = new JTextField("");

     JButton resetBtn = new JButton("清除"); 
     JButton submitBtn = new JButton("查詢");                   
    
     //建構子:類別CHCI_QR_panel
     public CHCI_QR_panel(){

         tLabel.setBounds(10,10,310,30);
         add(tLabel);

         nLabel.setBounds(10,50,100,30);
         add(nLabel);

         nTxtFd.setBounds(120,50,200,30);
         add(nTxtFd);

         submitBtn.setBounds(330,50,100,30);
         add(submitBtn);

         resetBtn.setBounds(440,50,100,30);
         resetBtn.addActionListener(ProcessClearFields);  //[查詢學生資料]操作畫面中[清除]按鈕加到[事件傾聽程式]
         add(resetBtn);

         cLabel.setBounds(10,130,100,30);
         add(cLabel);
         cTxtFd.setBounds(120,130,200,30);
         cTxtFd.setEditable(false);
         add(cTxtFd);

         eLabel.setBounds(10,170,100,30);
         add(eLabel);
         eTxtFd.setBounds(120,170,200,30);
         eTxtFd.setEditable(false);
         add(eTxtFd);

         mLabel.setBounds(10,210,100,30);
         add(mLabel);
         mTxtFd.setBounds(120,210,200,30);
         mTxtFd.setEditable(false);
         add(mTxtFd);

         setBackground(Color.green);
         setLocation(0,50);
         setSize(600,350);
         setLayout(null);
         setVisible(true);

     }

     //方法:清空容器內欄位
     public void clearPane(){

           nTxtFd.setText("");
           cTxtFd.setText("");
           eTxtFd.setText("");
           mTxtFd.setText("");

     }

     //事件傾聽程式: 處理點按[清除]按鈕
     public ActionListener ProcessClearFields = new ActionListener(){
         public void actionPerformed(ActionEvent e){
      
              clearPane();
 
         }    
     };

 } //end for: class CHCI_QR_panel

 