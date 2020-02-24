package com.reha.patientmicroservice.service;

import com.reha.patientmicroservice.domain.Patient;
import com.reha.patientmicroservice.domain.PatientDTO;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient getPatient(String patientID);

    Patient addPatient(PatientDTO patientDTO);

    void deletePatient(Patient patient);

    Patient changePatient(String patientID, PatientDTO patientDTO);

    void sendEmail();
}
