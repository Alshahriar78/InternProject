package org.healthcare.AppointmentBooking.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "doctors")
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private String address;
    @Column(nullable = false)
    private String specialization;
    @Column(nullable = false)
    private String experience;
    @Column(nullable = false)
    private String qualification;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    private String image;

    @ManyToMany
    @JoinTable(
            name = "doctor_user",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Users> users = new HashSet<>();

    @OneToMany()
    @JoinColumn(name = "doctor_id")
    private Set<DoctorAppointment> appointments = new HashSet<>();

}
