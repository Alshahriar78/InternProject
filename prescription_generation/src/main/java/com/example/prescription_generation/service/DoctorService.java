package com.example.prescription_generation.service;

import com.example.prescription_generation.model.dto.DoctorDTO;
import com.example.prescription_generation.model.entity.Muser.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    DoctorDTO getDoctorById(Long id);
    List<DoctorDTO> getAllDoctors();
    DoctorDTO updateDoctor(Long id, DoctorDTO dto);
    void deleteDoctor(Long id);

}