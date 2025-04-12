package com.ajay.hospital.repositories;

import com.ajay.hospital.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    List<Patient> findByBloodGroup(String bloodGroup);

    List<Patient> findByFirstName(String firstName);

    List<Patient> findByLastName(String lastName);

}
