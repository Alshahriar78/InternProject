package org.healthcare.AppointmentBooking.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.healthcare.AppointmentBooking.model.entity.Users;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabTestAppointmentDTO {
    @NotBlank(message = "Lab Test Name is required")
    private LocalDateTime appointmentDate;
    private String note;
    private Users users;



}





