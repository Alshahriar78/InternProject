package com.example.prescription_generation.controllers;

import com.example.prescription_generation.model.dto.DoctorDTO;
import com.example.prescription_generation.model.dto.PatientDTO;
import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.example.prescription_generation.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserRegistrationService userRegistrationService;

    @PostMapping("/register/doctor")
    public ResponseEntity<?> registerDoctor(@RequestBody DoctorDTO doctorDTO) {
        try {
            Doctor registeredDoctor = userRegistrationService.registerDoctor(doctorDTO);
            
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Doctor registered successfully");
            response.put("id", registeredDoctor.getId());
            response.put("email", registeredDoctor.getEmail());
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/register/patient")
    public ResponseEntity<?> registerPatient(@RequestBody PatientDTO patientDTO) {
        try {
            Patient registeredPatient = userRegistrationService.registerPatient(patientDTO);
            
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Patient registered successfully");
            response.put("id", registeredPatient.getId());
            response.put("email", registeredPatient.getEmail());
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}