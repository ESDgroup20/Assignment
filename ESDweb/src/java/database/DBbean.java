/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.User;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class DBbean {
    
//  Declare connection...
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pre = null;
    
//  Make connection to access DB    --------------NEEDED-EVERYTIME--------------
    public void getConnection(Connection c){
        this.conn = c;
    }
    
//  Show all data in this table     --------------SIGN-IN-PAGE------------------
    public String signInSelection(String table) throws SQLException{
//      query string
        String loginQuery = "SELECT * FROM "+table;
//      prepare statement 
        pre = conn.prepareStatement(loginQuery);
//      execute query
        rs = pre.executeQuery();
//      array of each elements
        StringBuilder sb = new StringBuilder();
//      get column size
        ResultSetMetaData metaData =  rs.getMetaData();
        int size = metaData.getColumnCount();
//      loop each column
        while (rs.next()) {
            for(int i=0; i<size; i++){  // check how many column
                String temp = rs.getString(i+1) + "&emsp;";
                sb.append(temp);
                sb.append("<br>");
            }
        }

        rs.close();
        pre.close();
        
//      return each elements each lines
        return sb.toString();
    }
    
//  Show only valid user from table     ------------SIGN-IN-PAGE----------------
    public User signInAuth(String table, String username, String password) throws SQLException{
        
//      String query
        String loginQueryAuth = "SELECT * FROM "+ table +" WHERE USERNAME = ? AND PASSWORD = ?";
//      prepare statement
        pre = conn.prepareStatement(loginQueryAuth);
//      access statement position by "?"
        pre.setString(1, username);
        pre.setString(2, password);
//      execute query
        rs = pre.executeQuery();
        
//      loop until get valid user to return
        while (rs.next()) { 
            User user = new User(rs.getString(1),rs.getString(2));
//          also save its role 
            user.setUserRole(rs.getString(3));
            return user;
        }
        
        rs.close();
        pre.close();
        
        return null;
    }
    
//  register new user       ------------------SIGN-UP-PAGE----------------------
    public User createUser(String table, String username, String password, String role) throws SQLException{
//      query 
        String registerQuery = "INSERT INTO "+table+" VALUES (?, ?, ?)";
//      prepare statement
        pre = conn.prepareStatement(registerQuery);
//      set statement position
        pre.setString(1, username);
        pre.setString(2, password);
        pre.setString(3, role);
        pre.executeUpdate();

        pre.close();
        
        return null;
    }
    
}
