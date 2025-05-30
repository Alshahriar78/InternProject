package com.example.prescription_generation.model.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Pattern;


@Getter
@Setter
public class DoctorDTO {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @NotBlank(message = "Username is required")
    @Size(min = 4, max = 50, message = "Username must be between 4 and 50 characters")
    private String username;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^(\\+8801|8801|01)[3-9]\\d{8}$",
            message = "Invalid Bangladeshi mobile number"
    )
    private String phoneNumber;

    @NotBlank(message = "Specialist field is required")
    @Size(max = 100, message = "Specialist must be less than 100 characters")
    private String specialist;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 100, message = "Password must be at least 6 characters")
    private String password;



    private boolean enabled;
}
