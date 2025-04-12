package com.ajay.hospital.service;

import com.ajay.hospital.domain.Appointment;
import com.ajay.hospital.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService() {

    }

    public AppointmentRepository getAppointmentRepository() {
        return appointmentRepository;
    }

    @Autowired(required = true)
    public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    /**
     * Schedule appointment for opd
     * @return
     */
    public boolean scheduleAppointment(Appointment appointment) {

        Objects.hash(appointment);
        return true;
    }

    /**
     * Reschedule appointment for opd
     * @return
     */
    public boolean reScheduleAppointment() {

        return true;
    }

    public boolean cancelAppointment() {
        return true;
    }
}
