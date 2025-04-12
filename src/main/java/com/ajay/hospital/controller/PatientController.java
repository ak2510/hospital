package com.ajay.hospital.controller;

import com.ajay.hospital.domain.Patient;
import com.ajay.hospital.dto.PatientDto;
import com.ajay.hospital.dto.PatientSearchDto;
import com.ajay.hospital.service.Patient.PatientService;
import com.ajay.hospital.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    public void registration() {
        //Do patient registration for the first time. Should have ability to check duplicate registration.

    }

    @GetMapping("/hello")
    public ResponseEntity<ApiResponse<String>> sayHello() {
        ApiResponse<String> response = ApiResponse.success("Hello world", "Request was successful");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @PostMapping
    public void createPatient(@Valid @RequestBody PatientDto patientDto) {

        patientService.createPatient(patientDto);
    }

    //@GetMapping("/all")
    @GetMapping
    public List<Patient> getAllPatient() {

        return patientService.getAllPatient();
    }

    @GetMapping("/{id}")
    public Map getPatientDetails(@PathVariable Long id) {

        return patientService.getPatientById(id);
    }

    @GetMapping("{id}/history")
    public void getPatientHistory(@PathVariable Long id) {

    }

    @PutMapping("{id}")
    public void updatePatientDetails(@PathVariable Long id, @RequestBody PatientDto patientDto) {
        patientService.updatePatient(patientDto);
    }

    @PostMapping("/search")
    public void search(@RequestBody PatientSearchDto patientSearchDto) {

    }
}
