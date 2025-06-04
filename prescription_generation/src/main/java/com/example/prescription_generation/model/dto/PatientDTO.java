package com.example.prescription_generation.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDTO {
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private String bloodGroup;
    private String address;
    private int age;
    private String gender;
    private String role;
    private boolean enabled;
}
