package com.example.prescription_generation.model.entity.Muser;


import com.example.prescription_generation.model.entity.precription.Prescription;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "patients_table")
public class Patient implements MUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private String role;
    private boolean enabled;
    @Getter
    @Setter
    private int age;
    @Getter
    @Setter
    private String gender;
    @Getter
    @Setter
    private String bloodGroup;
    @Getter
    @Setter
    private String address;
//    @Getter
//    @Setter
//   @OneToMany(mappedBy="patient")
//   private List<Prescription> prescription;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRole() {
        return "PATIENT";
    }
    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


}
