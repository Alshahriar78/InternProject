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
import org.springframework.transaction.annotation.Transactional;

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
    public PrescriptionDTO savePrescription(PrescriptionDTO prescriptionDTO) {

        Doctor doctor = doctorRepository.findById(prescriptionDTO.getDoctor_id())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        Patient patient = patientRepository.findById(prescriptionDTO.getPatient_id())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        Prescription prescription = prescriptionMapper.toEntity(prescriptionDTO);
        Doctor doctor1 = doctorRepository.findById(prescriptionDTO.getDoctor_id()).get();
        System.out.println(doctor1);
        prescription.setPrescribedBy(doctor1.getName());
        prescription.setDoctor(doctor1);
        Patient patient1 = patientRepository.findById(prescriptionDTO.getPatient_id()).get();
        System.out.println(patient1);
        prescription.setPatient(patient1);
        prescriptionRepository.save(prescription);
        return prescriptionMapper.toDTO(prescriptionRepository.save(prescription));

    }

    @Override
    public PrescriptionDTO getPrescriptionById(Long id) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found"));
        PrescriptionDTO prescriptionDTO = prescriptionMapper.toDTO(prescription);
        Doctor doctor1 = doctorRepository.findById(prescription.getDoctor().getId()).orElseThrow();
        prescriptionDTO.setPrescribedBy(doctor1.getName());


        return prescriptionDTO ;
    }

    @Override
    public List<PrescriptionDTO> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionRepository.findAll();
        List<PrescriptionDTO> prescriptionDTOS = prescriptionMapper.convertAllToDTO(prescriptions);
        for (PrescriptionDTO prescriptionDTO : prescriptionDTOS) {
            Doctor doctor1 = doctorRepository.findById(prescriptionDTO.getDoctor_id()).orElseThrow();
            prescriptionDTO.setPrescribedBy(doctor1.getName());
        }
        return prescriptionDTOS ;
    }

    @Override
    public PrescriptionDTO updatePrescription(Long id, PrescriptionDTO prescriptionDTO) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found"));

        Doctor doctor = doctorRepository.findById(prescriptionDTO.getDoctor_id())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        Patient patient = patientRepository.findById(prescriptionDTO.getPatient_id())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
         prescription = prescriptionMapper.toEntity(prescriptionDTO);
         prescription.setPrescribedBy(doctor.getName());
        return prescriptionMapper.toDTO(prescriptionRepository.save(prescription));
    }




    @Transactional
    public void deletePrescription(Long id) {
        // ১) ID অনুযায়ী Prescription খুঁজে নেই
        Prescription pres = prescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found with id: " + id));
        // ২) Prescription ডিলিট করি
        prescriptionRepository.delete(pres);
        // অথবা prescriptionRepository.deleteById(id);
    }
}

