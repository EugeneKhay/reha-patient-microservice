package com.reha.patientmicroservice.controller;

import com.reha.patientmicroservice.domain.Patient;
import com.reha.patientmicroservice.domain.PatientDTO;
import com.reha.patientmicroservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getAllPatients());
    }

    @GetMapping("{patientID}")
    public ResponseEntity<Patient> getOne(@PathVariable("patientID") String patientID) {
        Patient patient = patientService.getPatient(patientID);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody PatientDTO patientDto) {
        Patient patient = patientService.addPatient(patientDto);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @PutMapping("{patientID}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("patientID") String patientID,
                                                 @RequestBody PatientDTO patientDTO) {
        Patient patient = patientService.changePatient(patientID, patientDTO);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @DeleteMapping("{patientID}")
    public ResponseEntity<Patient> deletePatient(@PathVariable("patientID") String patientID) {
        Patient patient = patientService.getPatient(patientID);
        patientService.deletePatient(patient);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }
}
