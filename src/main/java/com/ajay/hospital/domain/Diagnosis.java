package com.ajay.hospital.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

/**
 * Diagnosis represent a class which is directly related to a disease.
 * A patient come to hospital or clinic to diagnosis of a particular disease.
 * A patient can have multiple unrelated disease
 */
@Entity
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "diagnosis", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Consultation> consultations;

    private String disease;

    private String comments;

    private LocalDate created;

    private LocalDate lastUpdated;
}
