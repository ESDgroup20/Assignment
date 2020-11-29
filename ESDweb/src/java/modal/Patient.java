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
public class Patient extends User{
 
    private String patientName;
    private String patientAddress;
    private String patientType;

    public Patient() {
    }

    public Patient(String patientName, String patientAddress) {
        this.patientName = patientName;
        this.patientAddress = patientAddress;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientType() {
        return patientType;
    }
    
    
    
}
