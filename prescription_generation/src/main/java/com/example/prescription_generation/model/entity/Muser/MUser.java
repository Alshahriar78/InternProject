package com.example.prescription_generation.model.entity.Muser;

public interface MUser {

    Long getId();

    void setName(String name);
    String getName();

    void setUsername(String username);
    String getUsername();

    void setEmail(String email);
    String getEmail();

    void setPhoneNumber(String phoneNumber);
    String getPhoneNumber();

    void setPassword(String password);
    String getPassword();

    void setRole(String role);
    String getRole();

    void setEnabled(boolean enabled);
    boolean isEnabled();

}
