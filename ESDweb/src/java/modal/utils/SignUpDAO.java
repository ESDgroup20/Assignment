/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal.utils;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modal.user.User;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class SignUpDAO {
    Connection conn = null;
    PreparedStatement pre = null;

    public SignUpDAO() {
    }
    
    public User createUser(String username, String password, String role) throws SQLException{
    
        String registerQuery = "INSERT INTO USERS VALUES (?, ?, ?)";
        conn = ConnectDB.getConnection();      
        pre = conn.prepareStatement(registerQuery);
        pre.setString(1, username);
        pre.setString(2, password);
        pre.setString(3, role);
        pre.executeUpdate();

        pre.close();
        conn.close();
        
        return null;
    }
}
