package org.healthcare.AppointmentBooking.model.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabDTO {
    @NotBlank(message = "Lab name is required")
    private String labName;
    @NotBlank(message = "Lab address is required")
    private String address;
    private double rating;
}
