package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class AppointmentTest {

    @Test
    void testAppointmentCreation() {
        Appointment appointment = new Appointment("001", new Date(), "Test Appointment");
        Assertions.assertEquals("001", appointment.getAppointmentID());
        Assertions.assertNotNull(appointment.getAppointmentDate());
        Assertions.assertEquals("Test Appointment", appointment.getDescription());
    }

    @Test
    void testInvalidAppointmentID() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment(null, new Date(), "Test Appointment"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("invalid@", new Date(), "Test Appointment"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("TooLongAppointmentID", new Date(), "Test Appointment"));
    }

    @Test
    void testInvalidAppointmentDate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("001", new Date(System.currentTimeMillis() - 1000000), "Test Appointment"));
    }

    @Test
    void testInvalidDescription() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("001", new Date(), null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("001", new Date(), "This description is too long and exceeds the limit of 50 characters."));
    }


}

