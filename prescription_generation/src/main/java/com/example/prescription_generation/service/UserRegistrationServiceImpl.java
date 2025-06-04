package com.example.prescription_generation.service;

import com.example.prescription_generation.model.dto.DoctorDTO;
import com.example.prescription_generation.model.dto.PatientDTO;
import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.example.prescription_generation.model.mapper.DoctorMapper;
import com.example.prescription_generation.model.mapper.PatientMapper;
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
    private final DoctorMapper doctorMapper ;
    private final PatientMapper patientMapper ;

    @Override
    public Doctor registerDoctor(DoctorDTO doctorDTO) {
        // Check if email already exists
        if (doctorRepository.findByEmail(doctorDTO.getEmail()).isPresent() ||
            patientRepository.findByEmail(doctorDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }
        doctorDTO.setPassword(passwordEncoder.encode(doctorDTO.getPassword()));
        doctorDTO.setRole("DOCTOR");
        doctorDTO.setEnabled(true);
        return doctorRepository.save(doctorMapper .toEntity(doctorDTO));
    }

    @Override
    public Patient registerPatient(PatientDTO patientDTO) {
        if (doctorRepository.findByEmail(patientDTO.getEmail()).isPresent() ||
            patientRepository.findByEmail(patientDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }
        patientDTO.setPassword(passwordEncoder.encode(patientDTO.getPassword()));
        patientDTO.setRole("PATIENT");
        patientDTO.setEnabled(true);
        return patientRepository.save(patientMapper.toEntity(patientDTO));
    }
}