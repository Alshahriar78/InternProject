package com.example.prescription_generation.model.dto;



import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class PrescriptionDTO {

    private Long id;

    private LocalDate prescriptionDate;
    @NotBlank(message = "Diagnosis is required")
    private String Diagonosis;
    @NotBlank(message = "Medicines is required")
    private String Medicines;
    @NotBlank(message = "Doctor name is required")
    private Long doctor_id;
    @NotBlank(message = "Patient name is required")
    private Long patient_id;
    private LocalDate nextVisitDate;
    private String prescribedBy;
}

