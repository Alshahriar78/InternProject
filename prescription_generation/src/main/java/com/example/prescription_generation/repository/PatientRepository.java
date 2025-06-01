package com.example.prescription_generation.repository;

import com.example.prescription_generation.model.entity.Muser.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByUsername(String username);
    
    Optional<Patient> findByEmail(String email);
}