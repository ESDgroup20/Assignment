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
public class AdminAppointmentList {

    private Connection conn;
    private String appointmentTable;

    public AdminAppointmentList(Connection conn, String appointmentTable) {
        this.conn = conn;
        this.appointmentTable = appointmentTable;
    }

    public String getAppointment() {
        DBbean dao = new DBbean();

        dao.getConnection(conn);

        String returnString = "Appointment: <br>";
        returnString = returnString + "Prescription ID, PatientName, MedicationName <br>";

        returnString = returnString + dao.selectAll(appointmentTable);

        return returnString;
    }
}
