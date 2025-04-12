package com.ajay.hospital.domain;

import jakarta.persistence.*;

/**
 * This table keeps all the medical reports of a particular patient.
 * Using this table we can easily get all the medical reports any time. Like give me all the sugar test report of patient with id 999 of year 2023.
 */
@Entity
public class Resources {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long patientId;

    private Long diagnosisId;

    private String s3Location;

    @OneToOne
    private ResourceType resourceType;

}
