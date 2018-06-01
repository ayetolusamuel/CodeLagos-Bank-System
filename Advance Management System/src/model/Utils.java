/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import advance.management.system.database.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Utils {

private final DatabaseConnection databaseConnection = new DatabaseConnection();
    
    
    public boolean loginClearTextVerification(String username,String password,String position){
      boolean flag;
        if (username.matches("")) {
            System.out.println("UserName is Empty!!!");
            flag = false;
        }
        else if(password.matches("")){
            System.out.println("Password is Empty!!!");
            flag = false;
             }
        else if (position.matches("Select")) {
            System.out.println("Invalid Position Selection!!!");
            flag = false;
            
        }else{
            flag = true;
        }
        return flag;
    }
    
    public boolean isUserNamePasswordSame(String username,String password){
        boolean flag;
        if (username.equalsIgnoreCase(password)) {System.out.println("UserName And Password cant be the Same!!");
            flag = false;
        }
        else{
            flag = true;
        }
        return flag;
                
    }
    
    public boolean isExistInDatabase(String username,String password,String position) throws SQLException{
        boolean flag = true;
        
        
        
        //select all from database if username,password,position from database is equals to username,password and position prompt exist in database
        //with flag = false else flag true;
        System.out.println("Login");
        
         try {
            String query = "SELECT * FROM login ";
             System.out.println("querry "+query);
            ResultSet resultSet;
            databaseConnection.open();
            Statement statement = databaseConnection.getStatement();
            resultSet = statement.executeQuery(query);
            
            if (!resultSet.next() ) {
                System.out.println("No Data yet!!!!");
         
            } else{

              
               String mUserName = resultSet.getString("username").trim();
               String mPassword = resultSet.getString("password").trim();
               String mPosition = resultSet.getString("position").trim();
           
                if (username.equalsIgnoreCase(mUserName) && password.equalsIgnoreCase(mPassword) && position.equalsIgnoreCase(mPosition)) {
                      JOptionPane.showMessageDialog(null, "User already exit in database");
                     flag = false;
                    
                }
                else{
                     flag = true;
                }
            }
               
        
    }
         catch(Exception exception){
             
         }
 return flag;   
}

}