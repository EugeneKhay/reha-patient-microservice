package com.reha.patientmicroservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private String name;
    private String surname;
    private String diagnosis;
    private String insuranceNumber;
    private String doctor;
    private Status status;

}
