package com.reha.patientmicroservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotNull
    private String patientID;

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    @Size(min = 2, max = 30)
    private String surname;

    @NotNull
    @Size(min = 2)
    private String diagnosis;

    @NotNull
    @Size(min = 5) // replace to Pattern
    private String insuranceNumber;

    @NotNull
    private String doctor;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private Status status;

}
