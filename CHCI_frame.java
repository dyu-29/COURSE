
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

 class CHCI_frame extends JFrame{      //系統的視窗

     CHCI_menu  myMenu = new CHCI_menu();                  //主功能選單物件(為JPanel,內含3個按鈕)     
     CHCI_OP_panel  myOP_pane = new CHCI_OP_panel();       //新增學生資料畫面物件(為JPanel,內含標籤,文字欄位,按鈕等)
     CHCI_QR_panel  myQR_pane = new CHCI_QR_panel();       //查詢學生資料畫面物件(為JPanel,內含標籤,文字欄位,按鈕等)              
    
     //建構子:類別CHCI_frame
     public CHCI_frame(){
         Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

         add(myMenu);        //將[主功能選單物件]加到此視窗中
         add(myOP_pane);     //將[新增學生資料畫面物件]加到此視窗中
         add(myQR_pane);     //將[查詢學生資料畫面物件]加到此視窗中

         myOP_pane.setVisible(true);   //預設[新增學生資料]畫面顯示
         myQR_pane.setVisible(false);  //預設[查詢學生資料]畫面隱藏

         //系統視窗的基本設定
         setTitle("學生管理系統-Student Management System (SMS)");
         setLocation((int) (screenSize.getWidth()*0.2), (int) (screenSize.getHeight()*0.2));
         setSize((int) (screenSize.getWidth()*0.6), (int) (screenSize.getHeight()*0.6));
         setLayout(null);
         setVisible(false);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

     }

 } //end for: class CHCI_frame

 
 