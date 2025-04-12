package com.ajay.hospital.dto;

import java.time.LocalDateTime;

public class AppointmentSchedule {
    private Long patientId;

    private Long doctorId;

    private LocalDateTime appointmentTime;

    private Float fee;
}
