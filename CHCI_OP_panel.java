

 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 //人機互動層類別
 //CHCI_OP_panel: Class HumanComputerInteraction_OPeration_panel (人機介面-[新增學生資料]操作畫面類別)

 class CHCI_OP_panel extends JPanel{

     JLabel tLabel = new JLabel("請輸入個人資料");
     JLabel nLabel = new JLabel("學生姓名");
     JLabel cLabel = new JLabel("學號");
     JLabel eLabel = new JLabel("電話");
     JLabel mLabel = new JLabel("在校成績");

     JTextField nTxtFd = new JTextField("");
     JTextField cTxtFd = new JTextField("");
     JTextField eTxtFd = new JTextField("");
     JTextField mTxtFd = new JTextField("");

     JButton clearBtn = new JButton("清除"); 
     JButton saveBtn = new JButton("儲存");                   
    
     //建構子:類別CHCI_OP_panel
     public CHCI_OP_panel(){

         tLabel.setBounds(10,10,310,30);
         add(tLabel);

         nLabel.setBounds(10,50,100,30);
         add(nLabel);
         nTxtFd.setBounds(120,50,200,30);
         add(nTxtFd);

         cLabel.setBounds(10,90,100,30);
         add(cLabel);
         cTxtFd.setBounds(120,90,200,30);
         add(cTxtFd);

         eLabel.setBounds(10,130,100,30);
         add(eLabel);
         eTxtFd.setBounds(120,130,200,30);
         add(eTxtFd);

         mLabel.setBounds(10,170,100,30);
         add(mLabel);
         mTxtFd.setBounds(120,170,200,30);
         add(mTxtFd);

         clearBtn.setBounds(150,250,100,40);
         clearBtn.addActionListener(ProcessClearFields);   //[新增學生資料]操作畫面中[清除]按鈕加到[事件傾聽程式]
         add(clearBtn);

         saveBtn.setBounds(350,250,100,40);
         add(saveBtn);

         setBackground(Color.yellow);
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
     

           

 } //end for: class CHCI_OP_panel
