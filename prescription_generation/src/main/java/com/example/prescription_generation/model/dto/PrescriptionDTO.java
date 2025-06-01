package com.example.prescription_generation.model.dto;


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

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Past(message = "Date  must be in the after Today's")
    @NotBlank(message = "appointment  Date Test Name is required")
    private LocalDateTime prescriptionDate;
    @NotBlank(message = "patient name is required")
    @Size(min = 5, max = 30, message = "Full name must be between 5 and 30 characters")
    private String patientName;
    private int age;
    @NotBlank(message = "Gender is required")
    private String gender;
    @NotBlank(message = "Diagnosis is required")
    private String Diagonosis;
    @NotBlank(message = "Medicines is required")
    private String Medicines;
//    @NotBlank(message = "Doctor name is required")
    private String doctorName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Past(message = "Date  must be in the after Today's")
    @NotNull(message = "Next Visiting Date is required")
    private LocalDate nextVisitDate;
}

