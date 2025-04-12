package com.ajay.hospital.service.Patient;

import com.ajay.hospital.domain.Patient;
import com.ajay.hospital.dto.PatientDto;
import com.ajay.hospital.expection.NotFoundException;
import com.ajay.hospital.repositories.PatientRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private EntityManager entityManager;

    private Session session;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostConstruct
    public void doSomething() {
        System.out.println("\n\n\n\n==========================================\n\n\n\n");
    }

    /**
     * create a new patient in the database
     */
    @Transactional
    public void createPatient(PatientDto patientDto) {
        //entityManager.persist(patientDto);

        session.createQuery("");
        Patient patient = new Patient();
        savePatient(patientDto, patient);

        TypedQuery<Patient> patientQuery = entityManager.createQuery("select p from Patient p where p.firstName = :firstName", Patient.class);
        List<Patient> patients = patientQuery.getResultList();
    }

    /**
     * Update an existing patient in the database
     */
    public void updatePatient(PatientDto patientDto) {
        Patient patient = patientRepository.findById(patientDto.getPatientId()).orElseThrow();
        savePatient(patientDto, patient);
    }

    public Map<String, String> getPatientDetails(Long patientId){
        return null;
    }

    /**
     * save patient to the database
     */
    public void savePatient(PatientDto patientDto, Patient patient) {
        //Patient patient = patientRepository.findById(patientDto.getPatientId()).orElseThrow(NotFoundException::new);

        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setAadhar(patientDto.getAadhar());
        patient.setEmail(patientDto.getEmail());
        patient.setMobileNo(patientDto.getMobileNo());

        patientRepository.save(patient);
    }

    /**
     * Get patient details from database based on patient id.
      * @param patientId
     * @return
     */
    public Map getPatientById(Long patientId) {
        Patient patient = patientRepository.findById(patientId).get();

        return Map.of(
                "firstName", patient.getFirstName(),
                "lastName", patient.getLastName(),
                "mobile", patient.getMobileNo(),
                "email", "ajay.gupta@gmail.com",
                "salary", 300567
        );

    }

    /**
     * Give me list of all patient details
     * @return - list of patient object
     */
    public List<Patient> getAllPatient() {
        return (List<Patient>) patientRepository.findAll();
    }

}
