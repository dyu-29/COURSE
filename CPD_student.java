

 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 //問題領域層類別
 //CPD_student: Class ProblemDomain_student (學生類別)

 class CPD_student{                    

     private String name;   //屬性:姓名字串
     private int chinese;   //屬性:國文成績整數
     private int english;   //屬性:英文成績整數
     private int math;
    
     //建構子:類別CPD_student
     public CPD_student(){
         name = "";
         chinese = 0;
         english = 0;
         math = 0;
     }

     //方法:設定姓名
     public void setName(String aName){
         name = aName;
     }

     //方法:設定中文成績
     public void setChinese(int chinese_score){
         chinese = chinese_score;
     }

     //方法:設定英文成績
     public void setEnglish(int english_score){
         english = english_score;
     }

     //方法:設定英文成績
     public void setMath(int math_score){
         math = math_score;
     }

     //方法:取得姓名
     public String getName(){
         return( name );
     }

     //方法:取得中文成績
     public int getChinese(){
         return( chinese );
     }

     //方法:取得英文成績
     public int getEnglish(){
         return( english );
     }

     //方法:取得英文成績
     public int getMath(){
         return( math );
     }

 } //end for: class CPD_student

