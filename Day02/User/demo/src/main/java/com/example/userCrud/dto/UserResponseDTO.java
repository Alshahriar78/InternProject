package com.example.usercrud.dto;

public class UserResponseDTO {
    private Long id;
    private String name;

    public UserResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
