package com.ajay.hospital.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PrescribedMedicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String medicineName;

    private String purpose;

    private String duration;

    private String route;

    private Boolean afterMeal;
}
