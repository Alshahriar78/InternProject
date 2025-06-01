package com.example.prescription_generation.service;

import com.example.prescription_generation.model.dto.PrescriptionDTO;
import com.example.prescription_generation.model.entity.precription.Prescription;
import com.example.prescription_generation.model.mapper.PrescriptionMapper;
import com.example.prescription_generation.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PrescriptionCreationImpl implements PrescriptionCreationService  {

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    private PrescriptionMapper prescriptionMapper;


    @Override
    public Prescription createPrescription(PrescriptionDTO prescriptionDTO){
        Prescription prescription = prescriptionMapper.toEntity(prescriptionDTO);
        prescriptionRepository.save(prescription);
        return prescription;
    }

}
