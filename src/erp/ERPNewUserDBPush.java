/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;


public class ERPNewUserDBPush {
    int count = 5000;
    private Connection con;
    private Statement st;
    private ResultSet rs;
   String name;
   String pass;
    
    public ERPNewUserDBPush() {
 try {
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpauth","root","");
     //jdbc:db2://dashdb-entry-yp-dal09-07.services.dal.bluemix.net:50000/BLUDB:user=dash10129;password=kJ@BpoKl56#W
     //"jdbc:mysql://localhost:3306/erpauth", "root", ""
     st = con.createStatement();} 
 catch (Exception ex) {
     System.out.println("Error: " + ex);}
    } 
    
    public void getData(String user){
 try {
    String query = "select password from ERPLOGIN where username='"+user+"' ";
     PreparedStatement prep = con.prepareStatement(query);
     System.out.println("Records from Database");
     rs = prep.executeQuery();
   if(rs.next()){
    pass = rs.getString("password");
}    
 } catch(Exception ex) {
     System.out.println(ex);
 }
    }
    
   public void setData(String name,String Email,String phone,String User,String Pass, String BU,String Sq,String Sqans){
 try {
     int c = count++;
     
 // int phoneno = Integer.parseInt(phone);
    String query = "INSERT INTO erpemp (empname,empemail,empphone,empid,empusername,empbu,empsecureq,empsecureans) VALUES (?, ?, ?,?,?,?,?,?)";
     String query2 = "INSERT INTO erplogin (username,password) VALUES (?, ?)";
     PreparedStatement prep = con.prepareStatement(query);
      PreparedStatement prep2 = con.prepareStatement(query2);
     prep.setString(1, name);
     prep.setString(2, Email);
     prep.setString(3, phone);
      prep.setInt(4, c);
      prep.setString(5,User);
       prep.setString(6,BU);
       prep.setString(7, Sq);
       prep.setString(8,Sqans);
      prep2.setString(1,User);
      prep2.setString(2, Pass);
     prep.executeUpdate();    
     prep2.executeUpdate();
 } catch(Exception ex) {
     System.out.println(ex);
 }
    } 
  
  
  
  
  
  
  
    
    
}
    