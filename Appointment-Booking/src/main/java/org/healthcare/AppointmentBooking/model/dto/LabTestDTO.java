package org.healthcare.AppointmentBooking.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Lab Test Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Lab Test Price must be greater than 0")
    private Double labTestPrice;
    @NotBlank(message = "Lab Test Image URL is required")
    private String labTestImageUrl;
}





