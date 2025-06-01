package com.example.prescription_generation.service;

import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;

public interface UserRegistrationService {
    
    Doctor registerDoctor(Doctor doctor);
    
    Patient registerPatient(Patient patient);
}