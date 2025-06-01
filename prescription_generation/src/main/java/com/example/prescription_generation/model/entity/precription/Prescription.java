package com.example.prescription_generation.model.entity.precription;

import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "prescriptions_table")

public class Prescription {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime prescriptionDate;
    private String patientName;
    private int age;
    private String gender;
    private String Diagonosis;
    private String Medicines;
    private LocalDate nextVisitDate;

    @ManyToOne
    private Doctor doctor;

//    @ManyToOne
//    private Patient patient;
}
