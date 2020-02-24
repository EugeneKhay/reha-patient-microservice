package com.reha.patientmicroservice.domain;

public enum Status {

    IS_BEIGN_TREATED ("Treated"),
    DISCHARGED("discharged");

    String value;

    Status(String value) {
        this.value = value;
    }
}
