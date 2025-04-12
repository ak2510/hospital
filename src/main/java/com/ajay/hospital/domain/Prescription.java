package com.ajay.hospital.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String notes;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "Prescription_id")
    private Set<PrescribedMedicine> prescribedMedicines;
}
