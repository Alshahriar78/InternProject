package com.example.prescription_generation.config;

import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.example.prescription_generation.repository.DoctorRepository;
import com.example.prescription_generation.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (doctorRepository.count() == 0) {
            Doctor doctor = new Doctor();
            doctor.setName("Dr. John Doe");
            doctor.setUsername("doctor1");
            doctor.setEmail("doctor@example.com");
            doctor.setPhoneNumber("1234567890");
            doctor.setPassword(passwordEncoder.encode("password"));
            doctor.setRole("DOCTOR");
            doctor.setEnabled(true);
            doctor.setSpecialist("Cardiologist");
            
            doctorRepository.save(doctor);
            
            System.out.println("Test doctor created: " + doctor.getEmail());
        }
        

        if (patientRepository.count() == 0) {
            Patient patient = new Patient();
            patient.setName("Jane Smith");
            patient.setUsername("patient1");
            patient.setEmail("patient@example.com");
            patient.setPhoneNumber("0987654321");
            patient.setPassword(passwordEncoder.encode("password"));
            patient.setRole("PATIENT");
            patient.setEnabled(true);
            patient.setAge(30);
            patient.setGender("Female");
            patient.setBloodGroup("O+");
            patient.setAddress("Mokamtola, Bogra City");
            
            patientRepository.save(patient);
            
            System.out.println("Test patient created: " + patient.getEmail());
        }
    }
}