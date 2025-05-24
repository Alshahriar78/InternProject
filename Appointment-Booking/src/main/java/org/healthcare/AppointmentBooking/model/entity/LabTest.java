package org.healthcare.AppointmentBooking.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "lab_test")
public class LabTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String labTestName;
    private String labTestDescription;
    private Double labTestPrice;
    private String labTestImageUrl;

    @ManyToMany(mappedBy = "labTest")
    private Set<Lab> labs = new HashSet<>();


    @OneToMany()
    private Set<LabTestAppointment> labTestAppointments = new HashSet<>();

}

