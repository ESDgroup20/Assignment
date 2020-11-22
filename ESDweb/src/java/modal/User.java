/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class User {
    String userName;
    String userPass;
    String userRole;    //Admin, Patient, Nurse, Doctor

    public User() {
    }

    public User(String userName, String userPass, String userRole) {
        this.userName = userName;
        this.userPass = userPass;
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getUserRole() {
        return userRole;
    }
    
    
}
