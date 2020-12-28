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
public class StaffListOfPrescriptions {

    private Connection conn;
    public String patientTable;
    private String medicationTable;
    private String prescriptionTable;

    private ArrayList<String> patientData;
    private ArrayList<String> medicationData;
    private ArrayList<String> prescriptionData;

    private String patientHTML;
    private String medicationHTML;
    private String refillsHTML;

    public StaffListOfPrescriptions(Connection conn, String patientTable, String medicationTable, String prescriptionTable) {
        this.conn = conn;
        this.patientTable = patientTable;
        this.medicationTable = medicationTable;
        this.prescriptionTable = prescriptionTable;

    }

    public void dbSelect() {
        DBbean dao = new DBbean();

        dao.getConnection(conn);
        patientData = dao.selectAllPatientNameID();

        medicationData = dao.selectAllMedName();

        prescriptionData = dao.selectAllPrescriptions();

    }

    public void createHTML() {

        patientHTML = "<select name='patient'>";
        for (int i = 0; i < patientData.size(); i += 2) {
            System.out.println("test");
            System.out.println(patientData.get(i));
            System.out.println(patientData.get(i + 1));
            patientHTML = patientHTML + "<option value='";
            patientHTML = patientHTML + patientData.get(i);
            patientHTML = patientHTML + "'>";
            patientHTML = patientHTML + patientData.get(i + 1);
            patientHTML = patientHTML + " ID:";
            patientHTML = patientHTML + patientData.get(i);
        }
        patientHTML = patientHTML + "</select>";
        

        medicationHTML = "<select name='medication'>";
        refillsHTML = "<select name='reffils'>";
        
        for (int i = 0; i < medicationData.size(); i += 2) {
            medicationHTML = medicationHTML + "<option value='";
            medicationHTML = medicationHTML + medicationData.get(i);
            medicationHTML = medicationHTML + "'>";
            medicationHTML = medicationHTML + medicationData.get(i);
            
            

        }
        
        
        medicationHTML = medicationHTML + "</select>";
        System.out.println(medicationData);
        System.out.println(medicationHTML);
    }

    public String dbInsert(String patient,String medication) {
        DBbean dao = new DBbean();

        dao.getConnection(conn);
        
        boolean sucsses =  dao.insertPrescription(patient,medication);
        
        if(sucsses){
            return "Patient ID:" + patient + "prescription for " + medication +"was sucsessful";
        }
        else{
            return "Patient ID:" + patient + "prescription for " + medication +"FAILED as it already exists";
        }
       

    }

    public String getPatientHTML() {
        return patientHTML;
    }

    public String getMedicationHTML() {
        return medicationHTML;
    }

}
