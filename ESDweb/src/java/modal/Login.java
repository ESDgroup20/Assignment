/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.SQLException;
import utils.ConnectDB;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class Login {
    
    ConnectDB conn = new ConnectDB();
    public String loginQuery;
    
    public Login() throws SQLException, ClassNotFoundException{
        this.loginQuery = conn.doSelectQuery("SELECT * FROM ACCOUNT");
    }
    
}
