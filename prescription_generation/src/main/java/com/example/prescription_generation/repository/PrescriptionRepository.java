package com.example.prescription_generation.repository;

import com.example.prescription_generation.model.dto.DayWisePrescriptionCountDTO;
import com.example.prescription_generation.model.entity.precription.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    List<Prescription> findByDoctor_Id(Long doctorId);
    List<Prescription> findByPrescriptionDate(LocalDate date);
    List<Prescription> findByPrescriptionDateBetween(LocalDate startOfLastMonth, LocalDate endOfLastMonth);
    List<Prescription> findByPrescriptionDateAfter(LocalDateTime date);
    List<Prescription> findByPrescriptionDateBefore(LocalDateTime date);

    @Query("SELECT p.prescriptionDate AS day, COUNT(p) AS cnt " +
            "FROM Prescription p " +
            "WHERE p.doctor.id = :doctorId " +
            "GROUP BY p.prescriptionDate " +
            "ORDER BY p.prescriptionDate")
    List<Object[]> findDayWiseCountByDoctor(@Param("doctorId") Long doctorId);

}
