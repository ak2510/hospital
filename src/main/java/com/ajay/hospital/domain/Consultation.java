package com.ajay.hospital.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Consultation class is used to save all the outcomes of meeting of patient and doctor in a single appointment.
 * In each consultation doctor will either prescribe some medicines or give other type of advice.
 * We are going to store every outcome in this entity class.
 */
@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Patient patient;

    /**
     * Doctor details who is taking care on the consultation day
     */
    @OneToOne
    private Doctor doctor;

    /**
     * Weight of the person on consultation day
     */
    private Float patientWeight;

    @ManyToOne
    @JoinColumn(name = "diagnosis_id")
    private Diagnosis diagnosis;

    /**
     * The doctor prescribe medicines in this consultation will be documented here
     */
    @OneToOne
    @JoinColumn(name = "prescription")
    private Prescription prescription;

    /**
     * Notes or advice given on the consultation
     */
    private String notes;

    private LocalDateTime dateTime;
}
