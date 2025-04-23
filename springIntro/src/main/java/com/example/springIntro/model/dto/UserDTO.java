package com.example.springIntro.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserDTO {
    @JsonProperty(value = "name", required = true, defaultValue = "AUser")
    private String name;
    @NotBlank(message = "Phone Number  is required")
    @JsonProperty(value = "phone_number", required = true, defaultValue = "017066")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @JsonProperty(namespace = "email", required = true, defaultValue = "example@gmail.com")
    private String email;
}


