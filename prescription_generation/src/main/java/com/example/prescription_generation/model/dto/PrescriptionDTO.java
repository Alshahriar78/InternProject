package com.example.prescription_generation.model.dto;


import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class PrescriptionDTO {



    private LocalDateTime prescriptionDate;
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

