package com.example.prescription_generation.model.mapper;


import com.example.prescription_generation.model.dto.PatientDTO;
import com.example.prescription_generation.model.dto.PrescriptionDTO;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.example.prescription_generation.model.entity.precription.Prescription;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PrescriptionMapper {

    public Prescription toEntity(PrescriptionDTO prescriptionDTO){
        if(prescriptionDTO == null){
            return null;
        }
        Prescription prescription = new Prescription();
        prescription.setPrescriptionDate(LocalDateTime.now());
//        prescription.setPatientName(prescriptionDTO.getPatientName());
//        prescription.setAge(prescriptionDTO.getAge());
//        prescription.setGender(prescriptionDTO.getGender());
        prescription.setDiagonosis(prescriptionDTO.getDiagonosis());
        prescription.setMedicines(prescriptionDTO.getMedicines());
        prescription.setNextVisitDate(prescriptionDTO.getNextVisitDate());


        return prescription;
    }
    public PrescriptionDTO toDTO(Prescription prescription){
        if(prescription == null){
            return null;
        }
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
//        prescriptionDTO.setAge(prescription.getAge());
//        prescriptionDTO.setGender(prescription.getGender());
        prescriptionDTO.setDiagonosis(prescription.getDiagonosis());
        prescriptionDTO.setMedicines(prescription.getMedicines());
        prescriptionDTO.setNextVisitDate(prescription.getNextVisitDate());
        return prescriptionDTO;
    }
    public List<PrescriptionDTO> convertAllToDTO(List<Prescription> prescriptions) {
        List<PrescriptionDTO> dtoList = new ArrayList<>();
        for (Prescription Prescription : prescriptions) {
            dtoList.add(toDTO(Prescription));
        }
        return dtoList;
    }

}
