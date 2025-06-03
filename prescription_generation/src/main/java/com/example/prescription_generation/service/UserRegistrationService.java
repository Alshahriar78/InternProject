package com.example.prescription_generation.service;

import com.example.prescription_generation.model.dto.DoctorDTO;
import com.example.prescription_generation.model.dto.PatientDTO;
import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;

public interface UserRegistrationService {
    
    Doctor registerDoctor(DoctorDTO doctorDTO);
    
    Patient registerPatient(PatientDTO patientDTO);
}