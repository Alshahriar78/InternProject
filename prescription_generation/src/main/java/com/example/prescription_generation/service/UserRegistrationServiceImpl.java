package com.example.prescription_generation.service;

import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.example.prescription_generation.repository.DoctorRepository;
import com.example.prescription_generation.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Doctor registerDoctor(Doctor doctor) {
        // Check if email already exists
        if (doctorRepository.findByEmail(doctor.getEmail()).isPresent() ||
            patientRepository.findByEmail(doctor.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        doctor.setRole("DOCTOR");
        doctor.setEnabled(true);
        return doctorRepository.save(doctor);
    }

    @Override
    public Patient registerPatient(Patient patient) {
        if (doctorRepository.findByEmail(patient.getEmail()).isPresent() ||
            patientRepository.findByEmail(patient.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        patient.setRole("PATIENT");
        patient.setEnabled(true);
        return patientRepository.save(patient);
    }
}