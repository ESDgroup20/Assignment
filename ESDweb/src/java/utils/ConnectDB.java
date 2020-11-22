/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class ConnectDB {
    private Connection con;
    private Statement state;
    private ResultSet rs;

    public String doSelectQuery(String query) throws SQLException, ClassNotFoundException {
        StringBuilder sb = new StringBuilder();

            // You will need to explicitly load this driver in a web app
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ESDweb", "root", "123456");
            state = con.createStatement();
            rs = state.executeQuery(query);
            ResultSetMetaData metaData =  rs.getMetaData();
            int size = metaData.getColumnCount();
            
            while (rs.next()) {
                
                for(int i=0; i<size; i++){  // check how many column
                    String temp = rs.getString(i+1) + "&emsp;";
                    sb.append(temp);
                    sb.append("<br>");
                }
              
//              System.out.println(rs.getString(1) + "&emsp;&emsp;&emsp;" + rs.getString(2)+"&emsp;&emsp;&emsp;"+rs.getString(3));
            }
            rs.close();
            state.close();
            con.close();
        return sb.toString();
    } //class
    
}
