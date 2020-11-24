/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal.utils;

import java.sql.SQLException;
import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import modal.user.User;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class LoginDAO {
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pre = null;
    
  
    public LoginDAO() throws SQLException {
//        this.loginQuery = conn.doSelectQuery("SELECT * FROM ACCOUNT");
        conn = ConnectDB.getConnection();
        
    }
    
    public String loginSelection() throws SQLException{
        
        String loginQuery = "SELECT * FROM ACCOUNT";
        pre = conn.prepareStatement(loginQuery);
        rs = pre.executeQuery();
        StringBuilder sb = new StringBuilder();
        ResultSetMetaData metaData =  rs.getMetaData();
        int size = metaData.getColumnCount();

        while (rs.next()) {
            for(int i=0; i<size; i++){  // check how many column
                String temp = rs.getString(i+1) + "&emsp;";
                sb.append(temp);
                sb.append("<br>");
            }
        }

        rs.close();
        conn.close();
//        return "CONNECTED";
        return sb.toString();
    }
    
    public User loginAuth(User user) throws SQLException{
        String username = user.getUserName();
        String password = user.getUserPass();
        
        String loginQueryAuth = "SELECT * FROM ACCOUNT WHERE USERNAME = ? AND PASSWORD = ?";
        
//        System.out.println("Your user name is " + username);          
//        System.out.println("Your password is " + password);
//        System.out.println("Query is: "+loginQueryAuth);
        
        pre = conn.prepareStatement(loginQueryAuth);
        pre.setString(1, username);
        pre.setString(2, password);
        rs = pre.executeQuery();
        
        if (!rs.next()) { user.setValid(false); }
        else { user.setValid(true); }
        
        rs.close();
        pre.close();
        conn.close();
        
        return user;
    }
    
    
}
