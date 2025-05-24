package org.healthcare.AppointmentBooking.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorAppointmentDTO {

    private String appointmentDate;
    private String appointmentTime;
    private String note;
    private Long doctor_id;
    private Long patient_id;


}
