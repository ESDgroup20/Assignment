/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Eli
 */
public class CreateUserBean {

    private ArrayList<String> userData;

    public CreateUserBean(ArrayList<String> userData) {
        this.userData = userData;
    }

    public UserBean create() {
        System.out.println("userData.get(1)" + userData.get(0));
        System.out.println("userData.get(2)" + userData.get(1));
        System.out.println("userData.get(3)" + userData.get(2));
        System.out.println("userData.get(4)" + userData.get(3));

        String username = userData.get(0);
        String password = userData.get(1);
        String role = userData.get(2);

        if (role.equals("Patient")) {
//            Create patient and admin bean if data needs to be different on each
            UserBean user = new UserBean();

            user.setPassword(password);
            user.setUserName(username);
            user.setRole(role);
            user.setName(userData.get(3));

            System.out.println("Is a Patient");
            return user;

        } else if (role.equals("Admin")) {
//            Create patient and admin bean if data needs to be different on each
            UserBean user = new UserBean();
            
            user.setPassword(password);
            user.setUserName(username);
            user.setRole(role);
            user.setName(userData.get(3));

            System.out.println("Is a admin");
            return user;
        } else if (role.equals("Doctor")) {

            StaffBean user = new StaffBean();

            user.setPassword(password);
            user.setUserName(username);
            user.setRole(role);
            user.setName(userData.get(3));
            user.setIsDoctor(true);

            System.out.println("Is a doctor");
            return user;

        } else if (role.equals("Nurse")) {

            StaffBean user = new StaffBean();

            user.setPassword(password);
            user.setUserName(username);
            user.setRole(role);
            user.setName(userData.get(3));
            user.setIsDoctor(false);

            System.out.println("Is a nurse");
            return user;

        }
        return null;
    }

    public ArrayList<String> getUserData() {
        return userData;
    }

}
