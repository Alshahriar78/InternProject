package com.example.prescription_generation.repository;

import com.example.prescription_generation.model.entity.Muser.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByUsername(String username);

    Optional<Doctor> findByEmail(String email);
}
