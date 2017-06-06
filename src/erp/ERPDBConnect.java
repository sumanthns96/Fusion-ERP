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
import javax.swing.JOptionPane;

public class ERPDBConnect {
    public Connection con;
    private Statement st;
    private ResultSet rs;
   String name;
   String pass;
    
    public ERPDBConnect() {
 try {
     
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpauth", "root", "");
     //"jdbc:mysql://localhost:3306/erpauth", "root", ""
     st = con.createStatement();} 
 catch (Exception ex) {
     
  
    
    } }
   
    public ERPDBConnect(ERPLoginerror obj) {
 try {
     
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpauth", "root", "");
     //"jdbc:mysql://localhost:3306/erpauth", "root", ""
     st = con.createStatement();} 
 catch (Exception ex) {
     obj.setVisible(true);
  obj.access=0;
    
    } }
       
    public void getData(String user){
 try {
    String query = "select password from erplogin where username='"+user+"' ";
     PreparedStatement prep = con.prepareStatement(query);
     //System.out.println("Records from Database");
     rs = prep.executeQuery();
   if(rs.next()){
    pass = rs.getString("password");
}    
 } catch(Exception ex) {
     System.out.println(ex);
 }
    }
    
   public void setData(String name,String phone,String Email){
 try {
    String query = "INSERT INTO ERPLOGIN (EMP_NAME,PHONE,EMAIL) VALUES (?, ?, ?)";
     PreparedStatement prep = con.prepareStatement(query);
     prep.setString(1, name);
     prep.setString(2, phone);
      prep.setString(2, Email);
     prep.executeUpdate();    
 } catch(Exception ex) {
     System.out.println(ex);
 }
    } 
  
  
  
  
  
  
  
    
    
}
    