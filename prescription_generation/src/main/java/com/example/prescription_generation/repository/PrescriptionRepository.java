package com.example.prescription_generation.repository;

import com.example.prescription_generation.model.entity.precription.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
