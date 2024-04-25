
 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 //人機互動層類別
 //CHCI_menu: Class HumanComputerInteraction_menu (人機介面-主功能選單類別)

 class CHCI_menu extends JPanel{    

     JButton queryBtn = new JButton("查詢學生資料"); 
     JButton insertBtn = new JButton("新增學生資料"); 
     JButton exitBtn = new JButton("關閉系統離開");                  
    
     //建構子:類別CHCI_menu
     public CHCI_menu(){

         exitBtn.setBounds(50,10,140,30);
         add(exitBtn);

         queryBtn.setBounds(230,10,140,30);
         add(queryBtn);

         insertBtn.setBounds(410,10,140,30);
         add(insertBtn);

         setBackground(Color.pink);
         setLocation(0,0);
         setSize(600,50);
         setLayout(null);
         setVisible(true);

     }

 } //end for: class CHCI_menu

 
