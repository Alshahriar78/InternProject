package com.example.prescription_generation.model.entity.precription;

import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "prescriptions_table")

public class Prescription {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate prescriptionDate;
    private String Diagonosis;
    private String Medicines;
    private LocalDate nextVisitDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String prescribedBy;
}
