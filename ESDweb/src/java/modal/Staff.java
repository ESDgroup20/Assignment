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
public class Staff extends User{
    private String staffName;
    private String staffAddress;

    public Staff() {
    }

    public Staff(String staffName, String staffAddress) {
        this.staffName = staffName;
        this.staffAddress = staffAddress;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }
    
}
