package model;

import javafx.collections.ObservableList;

import java.sql.Date;
/*
This class is for a Customer's Appointment. The data manipulated in this class
will be used to link numerous customers with certain appointments.
 */

public class Appointments {
    /**
     * Create variables that hold appoinment values from the database.
     */
    private int appointmentID;
    private String title,description,location,type;
    private Date startDate,endDate;
    /*
    Constructor
     */
    public Appointments(int customerID, String customerName, String address, String postalCode, String phone,int divisionID) {
        this.appointmentID = appointmentID;
        this.description = description;
        this.location = location;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public Appointments(int appointmentID, String title, String description, String location, int userID, int customerID, int contactID) {
        super();
    }


    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
