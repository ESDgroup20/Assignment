/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal.utils;

import java.sql.SQLException;
import database.ConnectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class LoginDAO {
    
    Connection conn = null;
    Statement state = null;
    ResultSet rs = null;
    
    String loginQuery = "SELECT * FROM ACCOUNT";
    
    public LoginDAO() throws SQLException {
//        this.loginQuery = conn.doSelectQuery("SELECT * FROM ACCOUNT");
        conn = ConnectDB.getConnection();
        state = conn.createStatement();
        rs = state.executeQuery(loginQuery);
        
        

    }
    
    public String LoginSelection() throws SQLException{
        
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
        state.close();
        conn.close();
//        return "CONNECTED";
        return sb.toString();
    }
    
}
