package com.example.prescription_generation.model.mapper;

import com.example.prescription_generation.model.dto.DoctorDTO;
import com.example.prescription_generation.model.entity.Muser.Doctor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorDTO doctorDTO){
        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
        doctor.setSpecialist(doctorDTO.getSpecialist());
        doctor.setPassword(doctorDTO.getPassword());
        doctor.setRole(doctorDTO.getRole());
        doctor.setEnabled(doctorDTO.isEnabled());
        return doctor;
    }

    public DoctorDTO toDTO(Doctor doctor){
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setName(doctor.getName());
        doctorDTO.setPhoneNumber(doctor.getPhoneNumber());
        doctorDTO.setSpecialist(doctor.getSpecialist());
        doctorDTO.setPassword(doctor.getPassword());
        doctorDTO.setEnabled(doctor.isEnabled());
        return doctorDTO;
    }

    public List<DoctorDTO> convertAllToDTO(List<Doctor> doctors) {
        List<DoctorDTO> dtoList = new ArrayList<>();
        for (Doctor doctor : doctors) {
            dtoList.add(toDTO(doctor));
        }
        return dtoList;
    }

    public List<Doctor> convertAllToEntity(List<DoctorDTO> doctorDTOS) {
        List<Doctor> doctors = new ArrayList<>();
        for (DoctorDTO doctorDTO : doctorDTOS) {
            doctors.add(toEntity(doctorDTO));
        }
        return doctors;
    }
}
