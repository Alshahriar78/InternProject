package com.example.prescription_generation.service;

import com.example.prescription_generation.exception.ResourceNotFoundException;
import com.example.prescription_generation.model.dto.PatientDTO;
import com.example.prescription_generation.model.dto.PrescriptionDTO;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.example.prescription_generation.model.mapper.PatientMapper;
import com.example.prescription_generation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final  PatientRepository patientRepository;
    @Autowired
    private  PatientMapper patientMapper;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }




    @Override
    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + id));
        return patientMapper.toDTO(patient);
    }

    @Override
    public List<PatientDTO> getPatientByName(String keyword){
        List<Patient> patient = patientRepository.findByNameContainingIgnoreCase(keyword);
        return patientMapper.convertAllToDTO(patient);
    }


    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patientMapper.convertAllToDTO(patients);
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO dto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + id));
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        return patientMapper.toDTO(patientRepository.save(patient));
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
