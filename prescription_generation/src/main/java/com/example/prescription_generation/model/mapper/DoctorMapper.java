package com.example.prescription_generation.model.mapper;

import com.example.prescription_generation.model.dto.DoctorDTO;
import com.example.prescription_generation.model.entity.Muser.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorDTO doctorDTO){
        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setUsername(doctorDTO.getUsername());
        doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
        doctor.setSpecialist(doctorDTO.getSpecialist());
        doctor.setPassword(doctorDTO.getPassword());
        doctor.setEnabled(doctorDTO.isEnabled());
        return doctor;
    }

    public DoctorDTO toDTO(Doctor doctor){
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setName(doctor.getName());
        doctorDTO.setUsername(doctor.getUsername());
        doctorDTO.setPhoneNumber(doctor.getPhoneNumber());
        doctorDTO.setSpecialist(doctor.getSpecialist());
        doctorDTO.setPassword(doctor.getPassword());
        doctorDTO.setEnabled(doctor.isEnabled());
        return doctorDTO;
    }
}
