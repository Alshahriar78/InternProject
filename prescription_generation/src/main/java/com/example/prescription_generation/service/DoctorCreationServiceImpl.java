package com.example.prescription_generation.service;

import com.example.prescription_generation.model.dto.DoctorDTO;
import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.mapper.DoctorMapper;
import com.example.prescription_generation.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorCreationServiceImpl implements DoctorRegisterService {

    private DoctorRepository doctorRepository;
    private DoctorMapper doctorMapper ;
    public DoctorCreationServiceImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper){
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public Doctor registerDoctor(DoctorDTO doctorDTO){
        Doctor doctor = doctorMapper.toEntity(doctorDTO);
        doctorRepository.save(doctor);
        return doctor;
    }

}
