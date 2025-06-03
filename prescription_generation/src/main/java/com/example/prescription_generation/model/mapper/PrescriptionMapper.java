package com.example.prescription_generation.model.mapper;



import com.example.prescription_generation.model.dto.PrescriptionDTO;
import com.example.prescription_generation.model.entity.precription.Prescription;
import com.example.prescription_generation.repository.DoctorRepository;
import com.example.prescription_generation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PrescriptionMapper {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public Prescription toEntity(PrescriptionDTO prescriptionDTO){
        if (prescriptionDTO == null || prescriptionDTO.getPatient_id() == null || prescriptionDTO.getDoctor_id() == null) {
            return null;
        }
        Prescription prescription = new Prescription();
        prescription.setPrescriptionDate(LocalDate.now());
        prescription.setDiagonosis(prescriptionDTO.getDiagonosis());
        prescription.setMedicines(prescriptionDTO.getMedicines());
        prescription.setNextVisitDate(prescriptionDTO.getNextVisitDate());
        prescription.setDoctor(doctorRepository.findById(prescriptionDTO.getDoctor_id()).orElseThrow());
        prescription.setPatient(patientRepository.findById(prescriptionDTO.getPatient_id()).orElseThrow());

        return prescription;
    }
    public PrescriptionDTO toDTO(Prescription prescription){
        if(prescription == null){
            return null;
        }
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setId(prescription.getId());
        prescriptionDTO.setPrescriptionDate(prescription.getPrescriptionDate());
        prescriptionDTO.setDiagonosis(prescription.getDiagonosis());
        prescriptionDTO.setMedicines(prescription.getMedicines());
        prescriptionDTO.setNextVisitDate(prescription.getNextVisitDate());
        prescriptionDTO.setDoctor_id(prescription.getDoctor().getId());
        prescriptionDTO.setPatient_id(prescription.getPatient().getId());
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
