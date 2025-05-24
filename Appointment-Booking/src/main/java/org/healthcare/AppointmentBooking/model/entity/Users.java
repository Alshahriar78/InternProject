package org.healthcare.AppointmentBooking.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String mobileNumber;

    private String gender;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private LocalDate dateOfBirth;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private List<String> roles  = List.of("Patient");

    @Column(nullable = false)
    private boolean enabled = true;

    @OneToMany()
    private List<DoctorAppointment> doctorAppointments = new ArrayList<>();

    @OneToMany()
    private List<LabTestAppointment> labTestAppointments;


    @Override
    public String toString() {
        return "UsersDTO{" +
                "id=" + id +
                ", name='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
