package com.example.prescription_generation.model.dto;



import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class PrescriptionDTO {

    private Long id;
    @NotNull(message = " Please Enter Prescription Date")
    @PastOrPresent(message = "Date must be today or earlier")
    private LocalDate prescriptionDate;
    @NotBlank(message = "Diagnosis is required")
    private String diagonosis;
    @NotBlank(message = "Medicines is required")
    private String medicines;
    @NotNull(message = "Doctor name is required")
    private Long doctor_id;
    @NotNull(message = "Patient name is required")
    private Long patient_id;
    private LocalDate nextVisitDate;
    private String prescribedBy;
    private String patient_name;
}

