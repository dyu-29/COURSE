

 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;

 //系統主控類別
 //CSMS: Class StudentManagementSystem (學生管理系統-SMS)

 class CSMS{                    

     //建立本系統所需的各個物件
	CHCI_login  myLogin = new CHCI_login();     //人機互動層: 使用者介面物件(myFrame,裡面又含有:myFrame.myMenu,myFrame.myOP_pane,myFrame.myQR_pane)
     CHCI_frame  myFrame = new CHCI_frame();       //人機互動層: 使用者介面物件(myFrame,裡面又含有:myFrame.myMenu,myFrame.myOP_pane,myFrame.myQR_pane)
     CPD_student myStudent = new CPD_student();    //問題領域層: 學生物件(myStudent)    
     CDM_dbma myDBMA = new CDM_dbma();             //資料管理層: 資料庫操作存取物件(myDBMA)
     CFD_check myCheck = new CFD_check();          //基礎層: 檢查物件(myCheck)

     //CSMS的建構子:
     CSMS(){
             
             //設定系統中相關物件是由哪一個[事件傾聽程式]負責處理其動作
		myLogin.bt.addActionListener(ClickBtn); 
             myFrame.myMenu.queryBtn.addActionListener(ProcessFunSelection);               //主功能選單的[查詢學生資料]按鈕
             myFrame.myMenu.insertBtn.addActionListener(ProcessFunSelection);              //主功能選單的[新增學生資料]按鈕
             myFrame.myMenu.exitBtn.addActionListener(ProcessFunSelection);                //主功能選單的[關閉系統離開]按鈕
             myFrame.myOP_pane.saveBtn.addActionListener(ProcessSaveStudentRecord);        //[新增學生資料]操作畫面的[儲存]按鈕
             myFrame.myQR_pane.submitBtn.addActionListener(ProcessSubmitStudentQuery);     //[查詢學生資料]查詢畫面的[查詢]按鈕
     }
	public ActionListener ClickBtn = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String acnt = myLogin.tf.getText();
			String pwd = myLogin.t2.getText();
			String pwdsearch;
			pwdsearch = myDBMA.findRD_in_TB_sysuser(acnt);
			if( pwdsearch.equals(pwd) ){
				myLogin.setVisible(false);
				myFrame.setVisible(true);
                                JOptionPane.showMessageDialog(null, "登入成功");
			}
			else
				JOptionPane.showMessageDialog(null,"帳號或密碼錯誤!");
		}
	};



      
     //事件傾聽程式: 處理主功能選單選按
     public ActionListener ProcessFunSelection = new ActionListener(){
         public void actionPerformed(ActionEvent e){
      
              if( e.getSource() == myFrame.myMenu.insertBtn ){
                       myFrame.myOP_pane.setVisible(true);        //顯示[新增學生資料]操作畫面
                       myFrame.myOP_pane.clearPane();             //清空[新增學生資料]操作畫面
                       myFrame.myQR_pane.setVisible(false);       //隱藏[查詢學生資料]查詢畫面      
                       myFrame.myQR_pane.clearPane();             //清空[查詢學生資料]查詢畫面
              }

              if( e.getSource() == myFrame.myMenu.queryBtn ){
                       myFrame.myOP_pane.setVisible(false);       //隱藏[新增學生資料]操作畫面
                       myFrame.myOP_pane.clearPane();             //清空[新增學生資料]操作畫面
                       myFrame.myQR_pane.setVisible(true);        //顯示[查詢學生資料]查詢畫面
                       myFrame.myQR_pane.clearPane();             //清空[查詢學生資料]查詢畫面
              }

              if( e.getSource() == myFrame.myMenu.exitBtn ){
                       System.exit(0);                            //關閉程式
              }
 
         }    
     };

     //事件傾聽程式: 處理學生資料儲存
     public ActionListener ProcessSaveStudentRecord = new ActionListener(){
         public void actionPerformed(ActionEvent e){
              
              boolean checkPass = true;            //用來記錄[輸入的學生資料]檢查結果
              String nameString = myFrame.myOP_pane.nTxtFd.getText();    //取得[輸入的學生資料]中的[姓名字串]
              String chineseString = myFrame.myOP_pane.cTxtFd.getText().trim();  //取得[輸入的學生資料]中的[國文成績字串] (註:trim()方法會把字串後面空白除掉)
              String englishString = myFrame.myOP_pane.eTxtFd.getText().trim();  //取得[輸入的學生資料]中的[英文成績字串]

              if( myCheck.checkNumber( chineseString ) == false ){  //利用檢查物件(myCheck)的checkNumber()方法,檢查chineseString是否為正確的數值格式,如:98,80,...等
                     checkPass = false;
                     JOptionPane.showMessageDialog(null,"[國文成績] 輸入資料錯誤!","操作警訊",JOptionPane.ERROR_MESSAGE);
              }

              if( myCheck.checkNumber( englishString ) == false ){  //利用檢查物件(myCheck)的checkNumber()方法,檢查englishString是否為正確的數值格式,如:98,80,...等
                     checkPass = false;
                     JOptionPane.showMessageDialog(null,"[英文成績] 輸入資料錯誤!","操作警訊",JOptionPane.ERROR_MESSAGE);
              }

              if(  nameString.length() == 0 ){    //檢查nameString是否有輸入任何字元,length()為計算字串長度方法,若長度為0則未輸入資料
                     checkPass = false;
                     JOptionPane.showMessageDialog(null,"[學生姓名] 空白未輸入資料!","操作警訊",JOptionPane.ERROR_MESSAGE);
              }

              //如果上述三個檢查都沒發現錯誤,則checkPass會維持true,即通過檢查,因此將學生的姓名,國文分數,英文分數設定到myStudent物件中對應屬性質  
              if( checkPass == true ){
                    myStudent.setName(nameString);
                    myStudent.setChinese( Integer.parseInt(chineseString) );    //註:Integer.parseInt()是將字串轉成整數的方法
                    myStudent.setEnglish( Integer.parseInt(englishString) );

                    myDBMA.insertRD_into_TB_student(myStudent);   //將學生物件傳入[資料庫操作存取物件(myDBMA)]的儲存學生紀錄方法(insertRD_into_TB_student())去儲存學生紀錄到資料庫
              }
 
         }    
     };

     //事件傾聽程式: 處理學生資料查詢
     public ActionListener ProcessSubmitStudentQuery = new ActionListener(){
         public void actionPerformed(ActionEvent e){
      
              String nameString = myFrame.myQR_pane.nTxtFd.getText();  //取得[輸入的查詢資料]中的[姓名字串]
              
              if(  nameString.length() > 0 ){    //如果[姓名字串]長度大於0,即有輸入姓名資料,才進入查詢處理
                     
                     String[] findResult = myDBMA.findRD_in_TB_student(nameString);   //呼叫[資料庫操作存取物件(myDBMA)]的查詢學生紀錄方法(findRD_into_TB_student())去查詢學生紀錄,並回傳儲存到findResult中
                     myFrame.myQR_pane.cTxtFd.setText(findResult[1]);    //將findResult陣列裝的索引1的元素(即中文成績字串)顯示在查詢結果欄位
                     myFrame.myQR_pane.eTxtFd.setText(findResult[2]);    //將findResult陣列裝的索引2的元素(即英文成績字串)顯示在查詢結果欄位

              } else {
                   JOptionPane.showMessageDialog(null,"[學生姓名] 空白未輸入資料，請填寫後再查詢!","操作警訊",JOptionPane.ERROR_MESSAGE);
              }
         }    
     };


 } //end for: class CSMS

 



 