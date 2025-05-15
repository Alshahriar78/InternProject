package org.healthcare.AppointmentBooking.model.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabTestAppointmentDTO {
    @NotBlank(message = "appointment  Date Test Name is required")
    private LocalDateTime appointmentDate;
    private String status ="Confirmed";
    @NotNull(message = "Lab Test Id is required")
    @Digits(integer = 10, fraction = 0, message = "Lab Test Id must be an integer")
    @Positive(message = "Lab Test Id must be positive")
    private Long labTest_id;
    @NotNull(message = "Lab Id is required")
    @Digits(integer = 10, fraction = 0, message = "Lab Id must be an integer")
    @Positive(message = "Lab Id must be positive")
    private Long lab_id;
    @Digits(integer = 10, fraction = 0, message = "Lab Id must be an integer")
    @Positive(message = "Lab Id must be positive")
    @NotBlank(message = "Doctor Id is required")
    private Long doctor_id;
    @NotBlank(message = "User Id is required")
    @Digits(integer = 10, fraction = 0, message = "Lab Id must be an integer")
    @Positive(message = "Lab Id must be positive")
    private Long users_id;

}





