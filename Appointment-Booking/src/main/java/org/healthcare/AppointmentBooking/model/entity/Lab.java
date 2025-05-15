package org.healthcare.AppointmentBooking.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hospital")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String labName;
    @Column(nullable = false)
    private String address;
    private double rating;

    @ManyToMany
    @JoinTable(
            name = "lab_test",
            joinColumns = @JoinColumn(name = "labs")
    )
    private Set<LabTest> labTest = new HashSet<>();

    @OneToMany(mappedBy = "lab")
    private Set<LabTestAppointment> labTestAppointments = new HashSet<>();


}
