package org.healthcare.AppointmentBooking.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDTO {
    @NotBlank(message = "Full name is required")
    private String doctorName;
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    @NotBlank(message = "Gender is required")
    private String gender;
    @NotBlank(message = "Address is required")
    private String address;
    private String experience;
    @NotBlank(message = "Qualification is required")
    private String qualification;
    @NotBlank(message = "Specialization is required")
    private String specialization;
    @NotBlank(message = "Date Of Brith is required")
    private LocalDate dateOfBirth;
    private String image;
}
