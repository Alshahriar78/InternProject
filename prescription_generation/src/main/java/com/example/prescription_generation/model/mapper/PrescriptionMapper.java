package com.example.prescription_generation.model.mapper;


import com.example.prescription_generation.model.dto.PrescriptionDTO;
import com.example.prescription_generation.model.entity.precription.Prescription;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PrescriptionMapper {

    public Prescription toEntity(PrescriptionDTO prescriptionDTO){
        if(prescriptionDTO == null){
            return null;
        }
        Prescription prescription = new Prescription();
        prescription.setPrescriptionDate(LocalDateTime.now());
        prescription.setPatientName(prescriptionDTO.getPatientName());
        prescription.setAge(prescriptionDTO.getAge());
        prescription.setGender(prescriptionDTO.getGender());
        prescription.setDiagonosis(prescriptionDTO.getDiagonosis());
        prescription.setMedicines(prescriptionDTO.getMedicines());
        prescription.setNextVisitDate(prescriptionDTO.getNextVisitDate());
//        prescription.setDoctor(); // add doctor with jwt token

        return prescription;
    }
    PrescriptionDTO toDTO(Prescription prescription){
        if(prescription == null){
            return null;
        }
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setPatientName(prescription.getPatientName());
        prescriptionDTO.setAge(prescription.getAge());
        prescriptionDTO.setGender(prescription.getGender());
        prescriptionDTO.setDiagonosis(prescription.getDiagonosis());
        prescriptionDTO.setMedicines(prescription.getMedicines());
        prescriptionDTO.setNextVisitDate(prescription.getNextVisitDate());
        prescriptionDTO.setDoctorName(prescription.getDoctor().getName());
        return prescriptionDTO;
    }

}
