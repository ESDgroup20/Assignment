/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Patient;
import model.Staff;
import model.User;

/**
 *
 * @author ESD20
 */
public class DBbean {

//  Declare connection...
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement pre = null;

//  Make connection to access DB    --------------NEEDED-EVERYTIME--------------
    public void getConnection(Connection c) {
        this.conn = c;
    } 
    
    public String getUsers(String Stable, String Ptable) {

        String returnString = "Staff: <br>";
        returnString = returnString + "Staff ID, Staff Name, Staff Address, Staff UserName <br>";
        returnString = returnString + selectByTable(Stable);
       

        returnString = returnString + "<br> Patient: <br>";
        returnString = returnString + "Patient ID, Patient Name, Patient Address, Patient UserName <br>";
        returnString = returnString + selectByTable(Ptable);

        return returnString;

    }
    
    public String getPrescription(String table) {

        String returnString = "Prescriptions: <br>";
        returnString = returnString + "PatientID, MedicationName, Refills <br>";
        returnString = returnString + selectByTable(table);

        return returnString;
    }
    
    public String getAppointment(String table) {

        String returnString = "Appointment: <br>";
        returnString = returnString + "Apointment ID, Staff ID,Patient ID, Date, Time, Slot, Charge <br>";
        returnString = returnString + selectByTable(table);

        return returnString;
    }
    
    

//  Show all data in this table     --------------FAST TRACK-PAGE------------------
    public String signInSelection(String table) {
        try {
            //      query string
            String loginQuery = "SELECT * FROM " + table;
            //      prepare statement
            pre = conn.prepareStatement(loginQuery);
            //      execute query
            rs = pre.executeQuery();
            //      array of each elements
            StringBuilder sb = new StringBuilder();
            //      get column size
            ResultSetMetaData metaData = rs.getMetaData();
            int size = metaData.getColumnCount();
            //      loop each column
            while (rs.next()) {
                for (int i = 0; i < size; i++) {  // check how many column
                    String temp = rs.getString(i + 1) + "&emsp;";
                    sb.append(temp);
                    sb.append("<br>");
                }
            }

            rs.close();
            pre.close();

            //      return each elements each lines
            return sb.toString();

        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//  -----------------------------------------------------------------------------


//  Show only valid user from table     ------------SIGN-IN-PAGE----------------
    public User signInAuth(String table, User user) {

        try {
            //      String query
            String loginQueryAuth = "SELECT * FROM " + table + " WHERE USERNAME = ? AND PASSWORD = ?";
            //      prepare statement
            pre = conn.prepareStatement(loginQueryAuth);
            //      access statement position by "?"
            pre.setString(1, user.getUserName());
            pre.setString(2, user.getUserPass());
            //      execute query
            rs = pre.executeQuery();

            while (rs.next()) {
                User getUser = new User(rs.getString(1), rs.getString(2), rs.getString(3));
                if(getUser.getUserRole().equals("Doctor") || getUser.getUserRole().equals("Nurse")){  
                    if(isStaffUnapproved(getUser.getUserName())){
//                        System.out.println("again: "+isStaffUnapproved(getUser.getUserName()));
                        return null;
                    } 
                } 
                return getUser;
                
            }
            rs.close();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    

//  create -----------------------------------SIGN-UP-PAGE----------------------
    public void createUser(String table, User user) {
        try {
            //      query
            String registerQuery = "INSERT INTO " + table + " VALUES (?, ?, ?)";
            //      prepare statement
            pre = conn.prepareStatement(registerQuery);
            //      set statement position
            pre.setString(1, user.getUserName());
            pre.setString(2, user.getUserPass());
            pre.setString(3, user.getUserRole());
            pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void createPatient(String table, Patient patient){
        try {
            //      query
            String registerQuery = "INSERT INTO "+table+" (PATIENTNAME, PATIENTADDRESS, USERNAME) VALUES (?, ?, ?)";
            //      prepare statement
            pre = conn.prepareStatement(registerQuery);
            //      set statement position
            pre.setString(1, patient.getPatientName());
            pre.setString(2, patient.getPatientAddress());
            pre.setString(3, patient.getPatientUsername());
            pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createStaff(String table, Staff staff){
        try {
            //      query 
            String registerQuery = "INSERT INTO "+table+" (STAFFNAME, STAFFADDRESS, USERNAME) VALUES (?, ?, ?)";
            //      prepare statement
//            System.out.println("query: "+registerQuery);
            pre = conn.prepareStatement(registerQuery);
            //      set statement position
            pre.setString(1, staff.getStaffName());
            pre.setString(2, staff.getStaffAddress());
            pre.setString(3, staff.getStaffUsername());
            pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//  delete ---------------------------------------------------------------------
    public void deleteUser(String table, String key) {
        try {
            String deleteQuery = "DELETE FROM " + table + " WHERE USERNAME='" + key + "'";
            System.out.println(deleteQuery);
            pre = conn.prepareStatement(deleteQuery);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStaff(String table, String key) {
        try {
            String deleteQuery = "DELETE FROM " + table + " WHERE STAFFID=" + key;
            System.out.println(deleteQuery);
            pre = conn.prepareStatement(deleteQuery);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deletePatient(String table, String key) {
        try {
            String deleteQuery = "DELETE FROM " + table + " WHERE PATIENTID=" + key;
            System.out.println(deleteQuery);
            pre = conn.prepareStatement(deleteQuery);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean deletePrescription(String patientID, String medication) {
        try {
            String deleteQuery = "DELETE FROM PRESCRIPTIONS WHERE PATIENTID = ? AND MEDICATIONNAME = ?";

            pre = conn.prepareStatement(deleteQuery);
            pre.setString(1, patientID);
            pre.setString(2, medication);
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
//  insert ---------------------------------------------------------------------
    public boolean insertPrescription(String patientID, String medication, Date date, String refills) {
        System.out.println("Insrt prescription function reached");
        try {
            System.out.println("Try  prescription function reached");
            String updateQuery = "INSERT INTO PRESCRIPTIONS (PATIENTID, MEDICATIONNAME, DATECREATED, LASTREFILLDATE, INITIALREFILLS, REMAININGREFILLS, APPROVED) VALUES (?,?,?,?,?,?,?)";

            pre = conn.prepareStatement(updateQuery);
            pre.setString(1, patientID);
            pre.setString(2, medication);
            pre.setDate(3, date);
            pre.setDate(4, date);
            pre.setString(5, refills);
            pre.setString(6, refills);
            pre.setBoolean(7, true);

            pre.executeUpdate();
            pre.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public void bookAppointment(int patientID, int staffID, String date, String time){
        
        try {
            
            
            String bookAppointment = "INSERT INTO APPOINTMENTS (PID, SID, ADATE, ATIME) VALUES (?,?,?,?)";
            
            pre = conn.prepareStatement(bookAppointment);
            pre.setInt(1, patientID);
            pre.setInt(2, staffID);
            pre.setDate(3, Date.valueOf(date));
            pre.setTime(4, Time.valueOf(time.concat(":00")));

            pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
//  select----------------------------------------------------------------------
    
    //  Show all data in this table     
    public String selectByTable(String table) {
        try {
            //      query string
            String loginQuery = "SELECT * FROM " + table;
            //      prepare statement
            pre = conn.prepareStatement(loginQuery);
            //      execute query
            rs = pre.executeQuery();
            //      array of each elements
            StringBuilder sb = new StringBuilder();
            //      get column size
            ResultSetMetaData metaData = rs.getMetaData();
            int size = metaData.getColumnCount();
   
//                  loop each column
            while (rs.next()) {
                for (int i = 0; i < size; i++) {  // check how many column
                    String temp = rs.getString(i + 1);
                    sb.append(" ");
                    sb.append(temp);

                }
                sb.append("<br>");
            }

            rs.close();
            pre.close();

            //      return each elements each lines
            return sb.toString();

        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
    public ArrayList selectByQuery(String query) {
        try {
            pre = conn.prepareStatement(query);
            rs = pre.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int size = metaData.getColumnCount();
            ArrayList<ArrayList> returnList = new ArrayList<>();

            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<>();
                for (int i = 0; i < size; i++) {  // check how many column
                    temp.add(rs.getString(i + 1));

                }
                returnList.add(temp);
            }

            rs.close();
            pre.close();

            return returnList;

        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String selectNameByRole(String table, String name, User user){
        String value = null;
        try {
            String selectQuery ="SELECT "+name+" "
                    + "FROM users,"+table+" "
                    + "WHERE  users.username = "+table+".USERNAME "
                    + "AND users.USERNAME = '"+user.getUserName()+"' "
                    + "AND users.PASSWORD = '"+user.getUserPass()+"' ";
//            System.out.println(selectQuery);
            pre = conn.prepareStatement(selectQuery);
            rs = pre.executeQuery();
  
            System.out.println(selectQuery);
            while (rs.next())
                value = rs.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }
    
    public int selectIdByName(String type, String name){
        try {
            String query;
            if(type.equals("patient")){
                query = "SELECT patientid FROM patients WHERE patientname = '"+name+"'";
            } else {  
                query = "SELECT staffid FROM staffs WHERE staffname = '"+name+"'";
            }
            pre = conn.prepareStatement(query);
            rs = pre.executeQuery();
            while (rs.next())
                return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
//    

    public String selectPatientName(String patientID) {

        try {
            //      query string

            //      prepare statement
            String query = "SELECT PATIENTNAME FROM PATIENTS WHERE PATIENTID = ?";

            pre = conn.prepareStatement(query);

            pre.setString(1, patientID);

            //      execute query
            rs = pre.executeQuery();
            //      array of each elements

            //      get column size
//                  loop each column
            String returnString = "";
            while (rs.next()) {

                returnString = rs.getString(1);

            }

            rs.close();
            pre.close();

            //      return each elements each lines
            return returnString;

        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList selectUnapprovedPrescriptions() {
        try {
            //      query string

            //      prepare statement
            String query = "SELECT * FROM Prescriptions WHERE APPROVED = false ";

            pre = conn.prepareStatement(query);

            //      execute query
            rs = pre.executeQuery();
            //      array of each elements

            //      get column size
            ArrayList<String> returnList = new ArrayList<String>();

//                  loop each column
            while (rs.next()) {
                returnList.add(rs.getString(1));
                returnList.add(rs.getString(2));

                returnList.add(rs.getString(5));
                returnList.add(rs.getString(6));

            }

            rs.close();
            pre.close();

            //      return each elements each lines
            return returnList;

        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    public ArrayList selectAllPatientNameID() {

        try {
            //      query string

            //      prepare statement
            String query = "SELECT PATIENTID,PATIENTNAME FROM PATIENTS";

            pre = conn.prepareStatement(query);
            //      execute query
            rs = pre.executeQuery();
            //      array of each elements

            //      get column size
            ArrayList<String> returnList = new ArrayList<String>();

//                  loop each column
            while (rs.next()) {

                returnList.add(rs.getString(1));
                returnList.add(rs.getString(2));

            }

            rs.close();
            pre.close();

            //      return each elements each lines
            return returnList;

        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList selectAllMedName() {

        try {
            //      query string

            //      prepare statement
            String query = "SELECT * FROM MEDICATION";

            pre = conn.prepareStatement(query);
            //      execute query
            rs = pre.executeQuery();
            //      array of each elements

            //      get column size
            ArrayList<String> returnList = new ArrayList<String>();

//                  loop each column
            while (rs.next()) {

                returnList.add(rs.getString(1));
                returnList.add(rs.getString(2));

            }

            rs.close();
            pre.close();

            //      return each elements each lines
            return returnList;

        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList selectAllPrescriptions() {

        try {
            //      query string

            //      prepare statement
            String query = "SELECT * FROM Prescription";

            pre = conn.prepareStatement(query);
            //      execute query
            rs = pre.executeQuery();
            //      array of each elements

            //      get column size
            ArrayList<String> returnList = new ArrayList<String>();

//                  loop each column
            while (rs.next()) {

                returnList.add(rs.getString(2));
                returnList.add(rs.getString(3));

            }

            rs.close();
            pre.close();

            //      return each elements each lines
            return returnList;

        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean isStaffUnapproved(String uname) {

        try {
            String sqlQuery = "SELECT * FROM Staffs WHERE USERNAME = '"+uname+"' AND APPROVED = FALSE";//        return null;
            pre = conn.prepareStatement(sqlQuery);
            rs = pre.executeQuery();

            while(rs.next()){
                if(uname.equals(rs.getString("USERNAME"))){
                    System.out.println(sqlQuery);
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
//  update
    
    public boolean update(String updateQuery) {

        try {
            pre = conn.prepareStatement(updateQuery);
            pre.executeUpdate();
            pre.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    

    

}
