/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapbo4;

import java.sql.*;

/**
 *
 * @author Afrien
 */
public class Connector {
    String DBurl = "jdbc:mysql://localhost/tugasjdbc";
    String DBuname = "root";
    String DBpw = "";
    
    Connection conn;
    Statement stat;

    public Connector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBurl, DBuname, DBpw);
            System.out.println("Connection success");
        } catch (Exception e) {
            System.out.println("Connection failed");
        }
    }
    
    void insertData(String username, String password){
        try {
            String query = "INSERT INTO `users`(`username`,`password`)" + "VALUES('" + username + "','" + password + "')";

            stat = conn.createStatement();
            stat.executeUpdate(query);

            System.out.println("Register success");
        } catch (Exception ex) {
            System.out.println("Register failed");
        }
    }
    
    boolean checkLogin(String username, String password){
        try {
            String query = "SELECT * FROM `users` WHERE username='" + username +"' AND password='" + password + "'";
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(query);
            if(resultSet.next()){
                stat.close();
                return true;
            }else{
                stat.close();
                return false;
            }
            
        } catch (Exception e) {  
            return false;
        }
    }
    
    boolean checkUsername(String username){
         try {
            String query = "SELECT * FROM `users` WHERE username='" + username +"'";
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(query);
            if(resultSet.next()){
                stat.close();
                return true;
            }else{
                stat.close();
                return false;
            }
            
        } catch (Exception e) {  
            return false;
        }
    }
}