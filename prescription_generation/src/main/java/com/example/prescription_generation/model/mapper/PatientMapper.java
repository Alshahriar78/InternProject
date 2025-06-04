package com.example.prescription_generation.model.mapper;

import com.example.prescription_generation.model.dto.DoctorDTO;
import com.example.prescription_generation.model.dto.PatientDTO;
import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientMapper {

    private final PasswordEncoder passwordEncoder;

    public PatientMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Patient toEntity(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setPhoneNumber(patientDTO.getPhoneNumber());
        patient.setEmail(patientDTO.getEmail());
        patient.setPassword(passwordEncoder.encode(patientDTO.getPassword()));
        patient.setBloodGroup(patientDTO.getBloodGroup());
        patient.setAddress(patientDTO.getAddress());
        patient.setAge(patientDTO.getAge());
        patient.setGender(patientDTO.getGender());
        return patient;
    }

    public PatientDTO toDTO(Patient patient){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName(patient.getName());
        patientDTO.setPhoneNumber(patient.getPhoneNumber());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setPassword(patient.getPassword());
        patientDTO.setBloodGroup(patient.getBloodGroup());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setAge(patient.getAge());
        patientDTO.setGender(patient.getGender());
        return patientDTO;
    }

    public List<PatientDTO> convertAllToDTO(List<Patient> patients) {
        List<PatientDTO> dtoList = new ArrayList<>();
        for (Patient patient : patients) {
            dtoList.add(toDTO(patient));
        }
        return dtoList;
    }

    public List<Patient> convertAllToEntity(List<PatientDTO> patientDTOS) {
        List<Patient> patients = new ArrayList<>();
        for (PatientDTO patientDTO : patientDTOS) {
            patients.add(toEntity(patientDTO));
        }
        return patients;
    }
}
