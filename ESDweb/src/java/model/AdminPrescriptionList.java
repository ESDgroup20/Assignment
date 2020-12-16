/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBbean;
import java.sql.Connection;

/**
 *
 * @author Eli
 */
public class AdminPrescriptionList {

    private Connection conn;
    private String prescriptionTable;

    public AdminPrescriptionList(Connection conn, String prescriptionTable) {
        this.conn = conn;
        this.prescriptionTable = prescriptionTable;
    }

    public String getPrescription() {
        DBbean dao = new DBbean();

        dao.getConnection(conn);

        String returnString = "Prescription: <br>";

        returnString = returnString + dao.signInSelection(prescriptionTable);

        return returnString;
    }
}
