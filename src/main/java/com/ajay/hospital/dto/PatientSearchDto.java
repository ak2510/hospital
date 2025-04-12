package com.ajay.hospital.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

/**
 * DTO class to get input data for Patient search service.
 */
@Getter
@Setter
@NoArgsConstructor
public class PatientSearchDto {

    private String firstName;

    private String lastName;

    private String aadhar;

    private String address;

    private String gender;

    private Date dateOfBirth;

    @Size(min = 10, max = 10, message = "Mobile number must be 10 digits only")
    private String mobileNo;

    @Email
    private String email;

    private String disease;

    private LocalDate diagnosisDate;
}
