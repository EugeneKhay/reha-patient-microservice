package com.reha.patientmicroservice.repository;

import com.reha.patientmicroservice.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByPatientID(String patientID);

}
