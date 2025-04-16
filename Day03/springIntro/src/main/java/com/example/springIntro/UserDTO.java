package com.example.springIntro;

public class UserDTO {
    private String name;
    private String email;

    // Constructors
    public UserDTO() {}

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
}

