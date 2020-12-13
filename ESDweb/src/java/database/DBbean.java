/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author ESD20
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
    public String signInSelection(String table){
        try {
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
            
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//  Show only valid user from table     ------------SIGN-IN-PAGE----------------
    public User signInAuth(String table, String username, String password){
        
        try {
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
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//  register new user       ------------------SIGN-UP-PAGE----------------------
    public void createUser(String table, String username, String password, String role){
        try {
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
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void createPatient(String table, String patientName, String patientAddress, String uname){
        try {
            //      query
            String registerQuery = "INSERT INTO "+table+"(PATIENTNAME, PATIENTADDRESS, UNAME) VALUES (?, ?, ?)";
            //      prepare statement
            pre = conn.prepareStatement(registerQuery);
            //      set statement position
            pre.setString(1, patientName);
            pre.setString(2, patientAddress);
            pre.setString(3, uname);
            pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createStaff(String table, String staffName, String staffAddress, String uname){
        try {
            //      query
            String registerQuery = "INSERT INTO "+table+"(STAFFNAME, STAFFADDRESS, UNAME) VALUES (?, ?, ?)";
            //      prepare statement
            pre = conn.prepareStatement(registerQuery);
            //      set statement position
            pre.setString(1, staffName);
            pre.setString(2, staffAddress);
            pre.setString(3, uname);
            pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteUser(String table, String key){
        try {
            String deleteQuery = "DELETE FROM "+ table +" WHERE USERNAME='"+key+"'";
            System.out.println(deleteQuery);
            pre = conn.prepareStatement(deleteQuery);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteStaff(String table, String key){
        try {
            String deleteQuery = "DELETE FROM "+ table +" WHERE STAFFID="+key;
            System.out.println(deleteQuery);
            pre = conn.prepareStatement(deleteQuery);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deletePatient(String table, String key){
        try {
            String deleteQuery = "DELETE FROM "+ table +" WHERE PATIENTID="+key;
            System.out.println(deleteQuery);
            pre = conn.prepareStatement(deleteQuery);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
