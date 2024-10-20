package com.company;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointmentList;

    public AppointmentService() {
        this.appointmentList = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        validateUniqueAppointmentID(appointment.getAppointmentID());
        appointmentList.add(appointment);
    }

    public void deleteAppointment(String appointmentID) {
        int i = 0;
        while (i < appointmentList.size()) {
            if (appointmentID.equals(appointmentList.get(i).getAppointmentID())) {
                appointmentList.remove(i);
                return;
            }
            i++;
        }
        throw new IllegalArgumentException("This appointment was already deleted or does not exist");
    }

    private void validateUniqueAppointmentID(String appointmentID) {
        for (Appointment appointment : appointmentList) {
            if (appointmentID.equals(appointment.getAppointmentID())) {
                throw new IllegalArgumentException("An appointment with this ID already exists");
            }
        }
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }
}

