package com.company;

import java.util.Date;

public class Appointment {
    private String appointmentID;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentID, Date appointmentDate, String description) {
        setAppointmentID(appointmentID);
        setAppointmentDate(appointmentDate);
        setDescription(description);
    }

    public void setAppointmentID(String appointmentID) {
        if (appointmentID == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        } else if (!appointmentID.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("Appointment ID contains invalid characters");
        } else if (appointmentID.length() > 10) {
            throw new IllegalArgumentException("The appointment ID cannot be longer than 10 characters. Your current appointment ID is: " + appointmentID.length() + " long.");
        } else {
            this.appointmentID = appointmentID;
        }
    }

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null");
        } else if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past");
        } else {
            this.appointmentDate = appointmentDate;
        }
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        } else if (description.length() > 50) {
            throw new IllegalArgumentException("The description cannot be longer than 50 characters. You entered a description " + description.length() + " characters long");
        } else {
            this.description = description;
        }
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}
