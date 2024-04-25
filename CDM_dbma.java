
 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 //資料管理層類別
 //CDM_dbma: Class DatabaseManagement_database manipulation and acess (資料庫操作與存取類別)

 class CDM_dbma{                    

     Connection connection;
     Statement statement;
    
     //建構子:類別Cdbma
     public CDM_dbma(){
       
     }

    
     //傳入一筆[學生姓名],查詢出該學生的[國文]與[英文]成績資料並回傳其查得[學生姓名][國文][英文]字串結果
     public String[] findRD_in_TB_student(String aName){

             Connection connection;
             PreparedStatement statement;
             ResultSet result;
             String cmdData;

             String myName="";
             int myChinese=0, myEnglish=0;
             String[] myResult = new String[3];
     
             //資料庫前置作業
             try{
                   Class.forName("com.mysql.jdbc.Driver");
             } catch(Exception e){
                   JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
             }

             try{
                    cmdData = "SELECT * FROM student WHERE name = ?";
                    connection = DriverManager.getConnection("jdbc:mysql://localhost/smsdb" + "?user=root&password=mysql");
                    statement = connection.prepareStatement(cmdData);
                    statement.setString(1,aName);
                    result = statement.executeQuery();
          
                    while( result.next() ){
                          myName = result.getString("name");
                          myChinese = result.getInt("chinese");
                          myEnglish = result.getInt("english");
                     }
                     statement.close();
                     
              } catch(SQLException e){
                     JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
              } 

              myResult[0] = myName;
              myResult[1] = String.valueOf(myChinese);   //String.valueOf() 是將[整數值]轉成字串
              myResult[2] = String.valueOf(myEnglish);

              return( myResult );            
     }
     //傳入一筆[學生姓名],查詢出該學生的[國文]與[英文]成績資料並回傳其查得[學生姓名][國文][英文]字串結果
     public String findRD_in_TB_sysuser(String aAcnt){

             Connection connection;
             PreparedStatement statement;
             ResultSet result;
             String cmdData;
             String myPwd = "";

             //資料庫前置作業
             try{
                   Class.forName("com.mysql.jdbc.Driver");
             } catch(Exception e){
                   JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
             }

             try{
                    cmdData = "SELECT * FROM sysuser WHERE acnt = ?";
                    connection = DriverManager.getConnection("jdbc:mysql://localhost/smsdb" + "?user=root&password=mysql");
                    statement = connection.prepareStatement(cmdData);
                    statement.setString(1,aAcnt);
                    result = statement.executeQuery();
          
                    while( result.next() )
                          myPwd = result.getString("pwd");

                     statement.close();
                     
              } catch(SQLException e){
                     JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
              } 


              return( myPwd );            
     }

     //傳入完整的一筆學生物件資料(aStudent),然後將此資料存入資料庫的student資料表中
     public void insertRD_into_TB_student(CPD_student aStudent){

             Connection connection;
             PreparedStatement statement;
             String cmdData;

             //資料庫前置作業
             try{
                   Class.forName("com.mysql.jdbc.Driver");
             } catch(Exception e){
                   JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
             }

             //在smsdb資料庫中, 新增一筆顧客資料到資料表: student   
             try{  
                    cmdData = "INSERT INTO student(name,chinese,english)"+
                              "VALUES(?,?,?)";

                    connection = DriverManager.getConnection("jdbc:mysql://localhost/smsdb" + "?user=root&password=mysql");
                    statement = connection.prepareStatement(cmdData);
                    statement.setString(1,aStudent.getName() );
                    statement.setInt(2, aStudent.getChinese() );
                    statement.setInt(3, aStudent.getEnglish() );
                    statement.setInt(4, aStudent.getMath() );
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"在smsdb資料庫中, 成功寫入一筆[學生記錄]到student資料表中!");
                    statement.close();

             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"在smsdb資料庫中, 寫入一筆[學生記錄]到student資料表中發生錯誤!");
             }
     } 
     
     //建立資料庫smsdb中的資料表:student
     public void createTB_student(){

            try{
                 connection = DriverManager.getConnection("jdbc:mysql://localhost/smsdb"+"?user=root&password=mysql");
                 statement = connection.createStatement();

                 String createTB = "CREATE TABLE student("+
                                   "name             VARCHAR(15), "+    //學生姓名
                                   "chinese          INT, "+            //國文成績
                                   "english          INT, "+
                                   "math             INT)";             //英文成績

                 statement.executeUpdate(createTB);
                 JOptionPane.showMessageDialog(null,"student資料表建立成功!");
                 statement.close();
       
            } catch(SQLException e){
                 if(statement != null) 
                       JOptionPane.showMessageDialog(null,"student資料表已存在,可正常使用!"); 
                 else
                       JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
           } catch(Exception e){
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
           }  
     } 

     public void createTB_sysuser(){

            try{
                 connection = DriverManager.getConnection("jdbc:mysql://localhost/smsdb"+"?user=root&password=mysql");
                 statement = connection.createStatement();

                 String createTB = "CREATE TABLE sysuser("+
                                   "acnt             VARCHAR(20), "+    //學生姓名
                                   "pwd          VARCHAR(20))";     //英文成績

                 statement.executeUpdate(createTB);
                 JOptionPane.showMessageDialog(null,"student資料表建立成功!");
                 statement.close();
       
            } catch(SQLException e){
                 if(statement != null) 
                       JOptionPane.showMessageDialog(null,"student資料表已存在,可正常使用!"); 
                 else
                       JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
           } catch(Exception e){
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
           }  
     } 

     //方法:建立資料庫smsdb
     public void createDB(){

         //安裝MySQL驅動程式, 與建立資料庫smsdb
         try{
              Class.forName("com.mysql.jdbc.Driver");
         } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
         }

         //建立 smsdb資料庫
         try{
              connection = DriverManager.getConnection("jdbc:mysql://localhost/"+
                                                       "?user=root&password=mysql");
              statement = connection.createStatement();
              String createDB = "CREATE DATABASE smsdb";
              statement.executeUpdate(createDB);
              JOptionPane.showMessageDialog(null,"smsdb資料庫建立成功!");
              statement.close();
              
         } catch(SQLException e){
              if(statement != null) 
                  JOptionPane.showMessageDialog(null,"smsdb資料庫已存在,可正常使用!");
              else
                  JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
         } catch(Exception e){
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         }
       
     } //end for: public void createDB()
 } //end for: class CDM_dbma
