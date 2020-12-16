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
 * @author Eli
 */
public class AdminUserList {

    private Connection conn;
    private String staffTable;
    private String patientTable;

    public AdminUserList(Connection conn, String staffTable, String patientTable) {
        this.conn = conn;
        this.staffTable = staffTable;
        this.patientTable = patientTable;
    }

    public String getUsers() {

        DBbean dao = new DBbean();

        dao.getConnection(conn);

        String returnString = "Staff: <br>";

         returnString = returnString + "Staff ID, Staff Name, Staff Address, Staff UserName <br>";
        returnString = returnString + dao.selectAll(staffTable);
       

        returnString = returnString + "<br> Patient: <br>";
        returnString = returnString + "Patient ID, Patient Name, Patient Address, Patient UserName <br>";
        returnString = returnString + dao.selectAll(patientTable);

        return returnString;

    }
}
