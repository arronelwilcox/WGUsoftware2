package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;


public class User {
//    private static ObservableList<User> userList = FXCollections.observableArrayList();
//    // Create Observable List for User data.
//    public static ObservableList<User> userList;
//
//    static {
//        try {
//            userList = listFromFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//
// }

//ECT: Europe/Paris
//EST: -05:00
//HST: -10:00
//MST: -07:00
    /**
     List Implemented from serializable data input via MySQLDatabase;
     */
    private int userID;
    /**
     User name and password are string variables.
     */
    private static String userName, password,lastUpdatedBy;
    /**
     Sets the format for the date
     */
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    /**
     This creates a Date instance.
     */
    private Date date = new Date();
    private Timestamp lastUpdate;
    /**
     Stores the result of the current date along with the desired format into a string for accessibility
     */
    private String currentDate = formatter.format(date);
    /**
     Boolean value to change forms based on the users language.
     */
    private Boolean languageUS = true;
    /**
    Timezone variable that gets the current Users timezone for display purposes.
     */
    private TimeZone timeZone = TimeZone.getDefault();
    /**
    Constructor
     */
    public User(int id, String username, String password, java.sql.Date dateCreated, Timestamp lastUpdate, String lastUpdatedBy) {
    }
    /**
    Getters and Setters for all the private variables.
     */
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCurrentDate() {
        return currentDate;
    }
    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
    public Boolean getLanguageUS() {
        return languageUS;
    }
    public void setLanguageUS(Boolean languageUS) {
        this.languageUS = languageUS;
    }
    public String lastUpdatedBy() {
        return lastUpdatedBy;
    }
    public void setCreatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public TimeZone getTimeZone() {
        return timeZone;
    }
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}
