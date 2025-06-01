package com.example.prescription_generation.service;

import com.example.prescription_generation.exception.ResourceNotFoundException;
import com.example.prescription_generation.model.dto.PrescriptionDTO;
import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.example.prescription_generation.model.entity.precription.Prescription;
import com.example.prescription_generation.model.mapper.PrescriptionMapper;
import com.example.prescription_generation.repository.DoctorRepository;
import com.example.prescription_generation.repository.PatientRepository;
import com.example.prescription_generation.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final PrescriptionMapper prescriptionMapper;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository,
                                   DoctorRepository doctorRepository,
                                   PatientRepository patientRepository, PrescriptionMapper prescriptionMapper) {
        this.prescriptionRepository = prescriptionRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.prescriptionMapper = prescriptionMapper;
    }

    @Override
    public PrescriptionDTO createPrescription(PrescriptionDTO prescriptionDTO) {
        Doctor doctor = doctorRepository.findById(prescriptionDTO.getDoctor_id())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        Patient patient = patientRepository.findById(prescriptionDTO.getPatient_id())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        Prescription prescription = prescriptionMapper.toEntity(prescriptionDTO);
        Doctor doctor1 = doctorRepository.findById(prescriptionDTO.getDoctor_id()).get();
        prescription.setDoctor(doctor1);
        Patient patient1 = patientRepository.findById(prescriptionDTO.getPatient_id()).get();
        prescription.setPatient(patient1);
        return prescriptionMapper.toDTO(prescriptionRepository.save(prescription));
    }

    @Override
    public PrescriptionDTO getPrescriptionById(Long id) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found"));
        return prescriptionMapper.toDTO(prescription);
    }

    @Override
    public List<PrescriptionDTO> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionRepository.findAll();
        return prescriptionMapper.convertAllToDTO(prescriptions);
    }

    @Override
    public PrescriptionDTO updatePrescription(Long id, PrescriptionDTO prescriptionDTO) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found"));

        Doctor doctor = doctorRepository.findById(prescriptionDTO.getDoctor_id())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        Patient patient = patientRepository.findById(prescriptionDTO.getPatient_id())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));


        prescription.setDoctor(doctor);
        prescription.setPatient(patient);


        return prescriptionMapper.toDTO(prescriptionRepository.save(prescription));
    }

    @Override
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }
}