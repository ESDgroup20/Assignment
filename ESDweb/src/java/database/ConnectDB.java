/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class ConnectDB {
    
    private static Connection conn = null;

    public static Connection getConnection(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ESDweb", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e.getMessage());
        }
        return conn;
//        state = con.createStatement();
//        rs = state.executeQuery(query);
//        ResultSetMetaData metaData =  rs.getMetaData();
//        int size = metaData.getColumnCount();
//
//        while (rs.next()) {
//
//            for(int i=0; i<size; i++){  // check how many column
//                String temp = rs.getString(i+1) + "&emsp;";
//                sb.append(temp);
//                sb.append("<br>");
//            }
//
////              System.out.println(rs.getString(1) + "&emsp;&emsp;&emsp;" + rs.getString(2)+"&emsp;&emsp;&emsp;"+rs.getString(3));
//        }
//        rs.close();
//        state.close();
//        con.close();
//        return sb.toString();
    } //class
    
}
