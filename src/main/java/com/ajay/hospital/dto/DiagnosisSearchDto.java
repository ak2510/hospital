package com.ajay.hospital.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO class to represent input data which will be used to search Diagnosis report
 */
@Getter
@Setter
@NoArgsConstructor
public class DiagnosisSearchDto {

    private LocalDate diagnosisDate;

    private String patientName;

    private String doctorName;

    private String diseaseName;

    private java.time.LocalDate firstDiagnosisDate;
}
