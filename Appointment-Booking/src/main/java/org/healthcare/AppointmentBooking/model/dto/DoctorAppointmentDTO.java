package org.healthcare.AppointmentBooking.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DoctorAppointmentDTO {
    private LocalDateTime date;
    private String note;
    private Long doctor_id;
    private Long patient_id;
}
