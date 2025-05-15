package org.healthcare.AppointmentBooking.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "lab_test_appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabTestAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "lab_id")
    private Lab lab;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "lab_test_id")
    private LabTest labTest;

    @Column(nullable = false)
    private String note;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
