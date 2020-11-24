/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal.user;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class User {
    String userId;
    String userName;
    String userPass;
    String userRole;    //Admin, Patient, Nurse, Doctor
    boolean valid;
    
    public User() {
    }

    public User(String userId, String userName, String userPass, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.userRole = userRole;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserRole() {
        return userRole;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
    
    
    
}
