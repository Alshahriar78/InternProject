package com.example.prescription_generation.service;

import com.example.prescription_generation.model.dto.DayWisePrescriptionCountDTO;
import com.example.prescription_generation.model.dto.PatientDTO;
import com.example.prescription_generation.model.dto.PrescriptionDTO;
import com.example.prescription_generation.model.entity.precription.Prescription;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PrescriptionService {
    PrescriptionDTO savePrescription(PrescriptionDTO prescriptionDTO);
    PrescriptionDTO getPrescriptionById(Long id);
    List<PrescriptionDTO> getAllPrescriptions();
    PrescriptionDTO updatePrescription(Long id, PrescriptionDTO dto);
    @Transactional
    void deletePrescription(Long id);
    List<PrescriptionDTO> getByDate(LocalDate date);
    List<PrescriptionDTO> getLastMonthPrescription();
    List<PrescriptionDTO> getPrescriptionsByLoggedInDoctor();
    @Transactional
    void deleteById(Long id);

    List<DayWisePrescriptionCountDTO> getDayWisePrescriptionCount();
}
