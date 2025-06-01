package com.example.prescription_generation.service;

import com.example.prescription_generation.model.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    PatientDTO getPatientById(Long id);
    List<PatientDTO> getPatientByName(String keyword);
    List<PatientDTO> getAllPatients();
    PatientDTO updatePatient(Long id, PatientDTO dto);
    void deletePatient(Long id);
}
