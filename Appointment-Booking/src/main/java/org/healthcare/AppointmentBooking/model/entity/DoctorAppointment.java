package org.healthcare.AppointmentBooking.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "doctor_appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String note;
    @Column(nullable = false)
    private String appointmentDate;
    private String appointmentTime;
    @Column(nullable = false)
    private String status = "Confirmed";

    @ManyToOne
    @JoinColumn(name = "doctor_id"  , nullable = false)
    private Doctor doctor;

    @ManyToOne()
    @JoinColumn(name = "user_id" , nullable = false)
    private Users user;
}
