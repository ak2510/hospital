package com.ajay.hospital.domain;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {

    @PostConstruct
    public void doAfterCreation() {
        System.out.println("Appointment is created");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private Integer fee;

    private String status; // Scheduled, Completed, Cancelled

    private LocalDateTime appointmentTime;

    private LocalDateTime createdOn;
}
