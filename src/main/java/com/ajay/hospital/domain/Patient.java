package com.ajay.hospital.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Date;
import java.util.Set;

/**
 * A patient represent a person who has some disease and come to hospital/clinic for diagnosis.
 * A patient can have multiple diseases over the time period. For each disease he/she has one diagnosis.
 */
@Entity
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "patientCache")
public class Patient extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bloodGroup;

    @OneToMany(mappedBy = "patient")
    private Set<Diagnosis> diagnosisSet;
}
