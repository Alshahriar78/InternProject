package com.example.prescription_generation.model.entity.Muser;

import com.example.prescription_generation.model.entity.precription.Prescription;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "doctors_table")
public class Doctor implements MUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String phoneNumber;

    private String specialist;
    private String password;
    private String role;

    @OneToMany(mappedBy = "doctor",
             fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Prescription> prescriptions;

    private boolean enabled;

    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username){
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
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String getRole() {
        return "DOCTOR";
    }

    @Override
    public void setRole(String role){
        this.role = role;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

}
