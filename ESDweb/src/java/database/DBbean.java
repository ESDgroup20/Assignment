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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserBean;

/**
 *
 * @author ESD20
 */
public class DBbean {

//  Declare connection...
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pre = null;

//  Make connection to access DB    --------------NEEDED-EVERYTIME--------------
    public void getConnection(Connection c) {
        this.conn = c;
<<<<<<< Updated upstream
    }

    public boolean update(String updateQuery) {
=======
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
>>>>>>> Stashed changes

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

    public ArrayList select(String query) {
        try {
            //      query string

            //      prepare statement
            pre = conn.prepareStatement(query);
            //      execute query
            rs = pre.executeQuery();
            //      array of each elements
            String returnString = "";
            //      get column size
            ResultSetMetaData metaData = rs.getMetaData();
            int size = metaData.getColumnCount();
            ArrayList<ArrayList> returnList = new ArrayList<ArrayList>();

//                  loop each column
            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<String>();
                for (int i = 0; i < size; i++) {  // check how many column
                    temp.add(rs.getString(i + 1));

                }
                returnList.add(temp);
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

<<<<<<< Updated upstream
    public ArrayList selectAllPatientNameID() {
=======
//  Show only valid user from table     ------------SIGN-IN-PAGE----------------
    public User signInAuth(String table, User user) {
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream

                returnList.add(rs.getString(1));
                returnList.add(rs.getString(2));
=======
                User getUser = new User(rs.getString(1), rs.getString(2), rs.getString(3));
                if (getUser.getUserRole().equals("Doctor") || getUser.getUserRole().equals("Nurse")) {
                    if (isStaffUnapproved(getUser.getUserName())) {
//                        System.out.println("again: "+isStaffUnapproved(getUser.getUserName()));
                        return null;
                    }
                }
                return getUser;
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
        try {
            //      query string

=======
    }

    public void createPatient(String table, Patient patient) {
        try {
            //      query
            String registerQuery = "INSERT INTO " + table + " (PATIENTNAME, PATIENTADDRESS, USERNAME) VALUES (?, ?, ?)";
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

    public void createStaff(String table, Staff staff) {
        try {
            //      query 
            String registerQuery = "INSERT INTO " + table + " (STAFFNAME, STAFFADDRESS, USERNAME) VALUES (?, ?, ?)";
>>>>>>> Stashed changes
            //      prepare statement
            String query = "SELECT * FROM MEDICATIONS";

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

<<<<<<< Updated upstream
            pre = conn.prepareStatement(query);
            //      execute query
            rs = pre.executeQuery();
            //      array of each elements

            //      get column size
            ArrayList<String> returnList = new ArrayList<String>();

//                  loop each column
            while (rs.next()) {
=======
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
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
=======
//  select----------------------------------------------------------------------
>>>>>>> Stashed changes
    //  Show all data in this table     
    public String selectAll(String table) {
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
<<<<<<< Updated upstream
=======

    public ArrayList selectByQuery(String query) {
        try {
            pre = conn.prepareStatement(query);
            rs = pre.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int size = metaData.getColumnCount();
            ArrayList<ArrayList> returnList = new ArrayList<>();
>>>>>>> Stashed changes

    public String getUsers(String Stable, String Ptable) {

        String returnString = "Staff: <br>";
        returnString = returnString + "Staff ID, Staff Name, Staff Address, Staff UserName <br>";
        returnString = returnString + selectAll(Stable);

        returnString = returnString + "<br> Patient: <br>";
        returnString = returnString + "Patient ID, Patient Name, Patient Address, Patient UserName <br>";
        returnString = returnString + selectAll(Ptable);

        return returnString;

    }

<<<<<<< Updated upstream
    public String getPrescription(String table) {

        String returnString = "Prescriptions: <br>";
        returnString = returnString + "PatientID, MedicationName, Refills <br>";
        returnString = returnString + selectAll(table);

        return returnString;
=======
    public String selectNameByRole(String table, String name, User user) {
        String value = null;
        try {
            String selectQuery = "SELECT " + name + " "
                    + "FROM users," + table + " "
                    + "WHERE  users.username = " + table + ".USERNAME "
                    + "AND users.USERNAME = '" + user.getUserName() + "' "
                    + "AND users.PASSWORD = '" + user.getUserPass() + "' ";
//            System.out.println(selectQuery);
            pre = conn.prepareStatement(selectQuery);
            rs = pre.executeQuery();

            System.out.println(selectQuery);
            while (rs.next()) {
                value = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
>>>>>>> Stashed changes
    }

    public String getAppointment(String table) {

        String returnString = "Appointment: <br>";
        returnString = returnString + "Apointment ID, Apointment ID, Staff ID,Patient ID, <br>";
        returnString = returnString + selectAll(table);

        return returnString;
    }

//  Show all data in this table     --------------SIGN-IN-PAGE------------------
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

    public boolean insertPrescription(String patient, String medication, int refills, Date date) {
        try {
<<<<<<< Updated upstream
=======
            //      query string

            //      prepare statement
            String query = "SELECT * FROM MEDICATIONS";
>>>>>>> Stashed changes

            String updateQuery = "INSERT INTO PRESCRIPTIONS (PATIENTID, MEDICATIONNAME, REFILLS,DATECREATED) VALUES (?, ?, ?, ?)";

            pre = conn.prepareStatement(updateQuery);
            pre.setString(1, patient);
            pre.setString(2, medication);
            pre.setInt(3, refills);
            pre.setDate(4, date);

            pre.executeUpdate();
            pre.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

//  Show only valid user from table     ------------SIGN-IN-PAGE----------------
    public ArrayList<String> signInAuth(String table, String username, String password) {

        try {
            //      String query
            String loginQueryAuth = "SELECT * FROM " + table + " WHERE USERNAME = ? AND PASSWORD = ?";
            //      prepare statement
<<<<<<< Updated upstream
            pre = conn.prepareStatement(loginQueryAuth);
            //      access statement position by "?"
            pre.setString(1, username);
            pre.setString(2, password);
=======
            String query = "SELECT * FROM Prescription";

            pre = conn.prepareStatement(query);

>>>>>>> Stashed changes
            //      execute query
            rs = pre.executeQuery();

            //      loop until get valid user to return
            ArrayList<String> returnList = new ArrayList<String>();
            while (rs.next()) {
                returnList.add(rs.getString(1).trim());
                returnList.add(rs.getString(2).trim());
                returnList.add(rs.getString(3).trim());
                returnList.add(rs.getString(4).trim());
            }
            rs.close();
            pre.close();
            return returnList;
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
<<<<<<< Updated upstream
=======

    public ArrayList selectPatientPrescriptions(String patientID) {

        try {
            //      query string

            //      prepare statement
            String query = "SELECT * FROM Prescriptions WHERE PATIENTID = ?";

            pre = conn.prepareStatement(query);

            pre.setString(1, patientID);

            //      execute query
            rs = pre.executeQuery();
            //      array of each elements

            //      get column size
            ArrayList<String> returnList = new ArrayList<String>();

//                  loop each column
            while (rs.next()) {

                returnList.add(rs.getString(2));
                returnList.add(rs.getString(3));
                returnList.add(rs.getString(4));
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

    public String selectMedQuantity(String Medname) {

        try {
            //      query string

            //      prepare statement
            String query = "SELECT QUANTITY FROM MEDICATIONS WHERE MEDICATIONNAME = ? ";

            pre = conn.prepareStatement(query);

            pre.setString(1, Medname);

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

    public boolean isStaffUnapproved(String uname) {
>>>>>>> Stashed changes

//  register new user       ------------------SIGN-UP-PAGE----------------------
    public void createUser(String table, String username, String password, String role) {
        try {
<<<<<<< Updated upstream
            //      query
            String registerQuery = "INSERT INTO " + table + " VALUES (?, ?, ?)";
            //      prepare statement
            pre = conn.prepareStatement(registerQuery);
            //      set statement position
            pre.setString(1, username);
            pre.setString(2, password);
            pre.setString(3, role);
            pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void createPatient(String table, String patientName, String patientAddress, String username) {
        try {
            //      query
            String registerQuery = "INSERT INTO " + table + " (PATIENTNAME, PATIENTADDRESS, USERNAME) VALUES (?, ?, ?)";
            //      prepare statement
            pre = conn.prepareStatement(registerQuery);
            //      set statement position
            pre.setString(1, patientName);
            pre.setString(2, patientAddress);
            pre.setString(3, username);
            pre.executeUpdate();
            pre.close();
=======
            String sqlQuery = "SELECT * FROM Staffs WHERE USERNAME = '" + uname + "' AND APPROVED = FALSE";//        return null;
            pre = conn.prepareStatement(sqlQuery);
            rs = pre.executeQuery();

            while (rs.next()) {
                if (uname.equals(rs.getString("USERNAME"))) {
                    System.out.println(sqlQuery);
                    return true;
                }
            }
>>>>>>> Stashed changes
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
<<<<<<< Updated upstream
=======

//  update
    public boolean update(String updateQuery) {
>>>>>>> Stashed changes

    public void createStaff(String table, String staffName, String staffAddress, String username) {
        try {
            //      query 
            String registerQuery = "INSERT INTO " + table + " (STAFFNAME, STAFFADDRESS, USERNAME) VALUES (?, ?, ?)";
            //      prepare statement
//            System.out.println("query: "+registerQuery);
            pre = conn.prepareStatement(registerQuery);
            //      set statement position
            pre.setString(1, staffName);
            pre.setString(2, staffAddress);
            pre.setString(3, username);
            pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public String selectNameByRole(String table, String role, String name, String usAuth, String pwAuth) {
        String value = null;
        try {
            String selectQuery = "SELECT " + name + " "
                    + "FROM users," + table + " "
                    + "WHERE  users.username = " + table + ".USERNAME "
                    + "AND users.role = '" + role + "' "
                    + "AND users.USERNAME = '" + usAuth + "' "
                    + "AND users.PASSWORD = '" + pwAuth + "' ";
//            System.out.println(selectQuery);
            pre = conn.prepareStatement(selectQuery);
            rs = pre.executeQuery();

            while (rs.next()) {
                value = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }
}
