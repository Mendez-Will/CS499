package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class AppointmentServiceTest {

    @Test
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("001", new Date(), "Test Appointment");

        service.addAppointment(appointment);
        Assertions.assertEquals(1, service.getAppointmentList().size());
        Assertions.assertEquals("001", service.getAppointmentList().get(0).getAppointmentID());
    }

    @Test
    void testAddDuplicateAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment1 = new Appointment("001", new Date(), "Test Appointment");
        Appointment appointment2 = new Appointment("001", new Date(), "Another Appointment");

        service.addAppointment(appointment1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment2));
    }

    @Test
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("001", new Date(), "Test Appointment");

        service.addAppointment(appointment);
        Assertions.assertEquals(1, service.getAppointmentList().size());
        service.deleteAppointment("001");
        Assertions.assertEquals(0, service.getAppointmentList().size());
    }

    @Test
    void testDeleteNonexistentAppointment() {
        AppointmentService service = new AppointmentService();

        Assertions.assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("001"));
    }

}

