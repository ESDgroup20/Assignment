/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBbean;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class DropdownStaffList {
    private ArrayList<String> staffNameList;
    private Connection conn;
    
    public DropdownStaffList(Connection conn) {
        this.conn = conn;
    }

    public DropdownStaffList() {
    }

    public void dbSelectStaffName() {

        DBbean dao = new DBbean();

        dao.getConnection(conn);

        String sqlQuery = "SELECT staffname FROM users,staffs WHERE  users.username = staffs.USERNAME AND staffs.APPROVED = true";
        
        System.out.println("sql: "+sqlQuery);
        
        staffNameList = dao.selectByQuery(sqlQuery);

    }
    
    public String createHTML() {
        
        System.out.println("Bring to dropdownlist class");
        System.out.println("size: "+staffNameList.size());
        String staffNameBoxHTML = "<select name = \"staffNameList\"> ";
        for (int i = 0; i < staffNameList.size(); i++) {
            staffNameBoxHTML = staffNameBoxHTML + "<option value=\"" + staffNameList.get(i) + "\"></option>";
//            staffNameBoxHTML = staffNameBoxHTML + staffNameList.get(i) + "";

        }
        staffNameBoxHTML = staffNameBoxHTML + "</select>";
        staffNameBoxHTML = staffNameBoxHTML + "<button class=\"btn btn-primary col-12\" type=\"submit\" name=\"action\" value=\"SelectStaff\">Select This Staff</button>";
//
        return staffNameBoxHTML;

       

    }

    public ArrayList<String> getStaffNameList() {
        return staffNameList;
    }
    
}
