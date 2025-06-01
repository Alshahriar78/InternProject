package com.example.prescription_generation.service;

import com.example.prescription_generation.model.dto.PrescriptionDTO;

import com.example.prescription_generation.model.entity.precription.Prescription;

public interface PrescriptionCreationService {
    Prescription createPrescription(PrescriptionDTO prescriptionDTO);
}
