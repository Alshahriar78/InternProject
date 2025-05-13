package org.healthcare.AppointmentBooking.model.entity;

import jakarta.persistence.*;
import lombok.Data;

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

}

