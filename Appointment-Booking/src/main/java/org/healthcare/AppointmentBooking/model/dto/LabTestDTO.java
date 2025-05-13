package org.healthcare.AppointmentBooking.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabTestDTO {
    @NotBlank(message = "Lab Test Name is required")
    private String labTestName;
    @NotBlank(message = "Lab Test Description is required")
    private String labTestDescription;
    private Double labTestPrice;
    private String labTestImageUrl;



}





