package com.reha.patientmicroservice.service;

import com.reha.patientmicroservice.domain.Patient;
import com.reha.patientmicroservice.domain.PatientDTO;
import com.reha.patientmicroservice.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Patient> getAllPatients() {
        //sendEmail();
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatient(String patientID) {
        return patientRepository.findByPatientID(patientID);
    }

    @Override
    public Patient addPatient(PatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        patient.setPatientID(UUID.randomUUID().toString());
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Patient patient) {
        patientRepository.delete(patient);
    }

    @Override
    public Patient changePatient(String patientID, PatientDTO patientDTO) {
        Patient patient = getPatient(patientID);
        if (patientDTO.getName() != null) patient.setName(patientDTO.getName());
        if (patientDTO.getSurname() != null) patient.setSurname(patientDTO.getSurname());
        if (patientDTO.getDiagnosis() != null) patient.setDiagnosis(patientDTO.getDiagnosis());
        if (patientDTO.getDoctor() != null) patient.setDoctor(patientDTO.getDoctor());
        if (patientDTO.getInsuranceNumber() != null) patient.setInsuranceNumber(patientDTO.getInsuranceNumber());
        if (patientDTO.getStatus() != null) patient.setStatus(patientDTO.getStatus());
        //BeanUtils.copyProperties(patientDTO, patient, "id", "patientID");
        return patientRepository.save(patient);
    }

    @Override
    public void sendEmail() {
        Email email = EmailBuilder.startingBlank()
                .to("seelenrauf@mail.ru")
                .from("4358514@gmail.com")
                .withSubject("Test Email")
                .withPlainText("Just an email")
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587,
                        "4358514@gmail.com", "czbvsrvsmkydenxo")
                .async()
                .buildMailer();
        mailer.sendMail(email);
    }
}
