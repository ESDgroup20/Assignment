/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal.utils;

import java.sql.SQLException;
import database.ConnectDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.user.User;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class LoginDAO {
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pre = null;
    
  
    public LoginDAO(){
    }  
    
    
    public String loginSelection() throws SQLException{
        
        String loginQuery = "SELECT * FROM USERS";
        conn = ConnectDB.getConnection();
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
    
    public User loginAuth(String username, String password) throws SQLException{
        
        String loginQueryAuth = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
        conn = ConnectDB.getConnection();      
        pre = conn.prepareStatement(loginQueryAuth);
        pre.setString(1, username);
        pre.setString(2, password);
        rs = pre.executeQuery();
        
        while (rs.next()) { 
            User user = new User(rs.getString(1),rs.getString(2));
            return user;
        }
        
        rs.close();
        pre.close();
        conn.close();
        
        return null;
    }
    
    
    
}
