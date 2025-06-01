package com.example.prescription_generation.service;

import com.example.prescription_generation.exception.ResourceNotFoundException;
import com.example.prescription_generation.model.dto.DoctorDTO;
import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.mapper.DoctorMapper;
import com.example.prescription_generation.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private  DoctorRepository doctorRepository;
    @Autowired
    private  DoctorMapper doctorMapper ;


    @Override
    public DoctorDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        return doctorMapper.toDTO(doctor);
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctorMapper.convertAllToDTO(doctors);
    }

    @Override
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        return doctorMapper.toDTO(doctorRepository.save(doctor));
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }


}
