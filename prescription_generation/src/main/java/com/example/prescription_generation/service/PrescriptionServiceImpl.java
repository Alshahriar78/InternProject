package com.example.prescription_generation.service;

import com.example.prescription_generation.exception.ResourceNotFoundException;
import com.example.prescription_generation.model.dto.DayWisePrescriptionCountDTO;
import com.example.prescription_generation.model.dto.PrescriptionDTO;
import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.example.prescription_generation.model.entity.precription.Prescription;
import com.example.prescription_generation.model.mapper.PrescriptionMapper;
import com.example.prescription_generation.repository.DoctorRepository;
import com.example.prescription_generation.repository.PatientRepository;
import com.example.prescription_generation.repository.PrescriptionRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
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
        prescription.setPrescribedBy(doctor1.getName());
        prescription.setDoctor(doctor1);
        Patient patient1 = patientRepository.findById(prescriptionDTO.getPatient_id()).get();
        prescription.setPatient(patient1);
        prescription.setPatientName(patient.getName());
        prescriptionRepository.save(prescription);
        return prescriptionMapper.toDTO(prescriptionRepository.save(prescription));

    }

    @Override
    public PrescriptionDTO getPrescriptionById(Long id) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found"));
        PrescriptionDTO prescriptionDTO = prescriptionMapper.toDTO(prescription);
        Doctor doctor1 = doctorRepository.findById(prescription.getDoctor().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        return prescriptionDTO ;
    }

    @Override
    public List<PrescriptionDTO> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionRepository.findAll();
        return  prescriptionMapper.convertAllToDTO(prescriptions) ;
    }

    @Override
    public PrescriptionDTO updatePrescription(Long id, PrescriptionDTO prescriptionDTO) {
        Prescription existing = prescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found with id: " + id));

        Doctor doctor = doctorRepository.findById(prescriptionDTO.getDoctor_id())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + prescriptionDTO.getDoctor_id()));
        Patient patient = patientRepository.findById(prescriptionDTO.getPatient_id())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + prescriptionDTO.getPatient_id()));
        existing.setPrescriptionDate(prescriptionDTO.getPrescriptionDate());
        existing.setDoctor(doctor);
        existing.setPatient(patient);
        existing.setDiagonosis(prescriptionDTO.getDiagonosis());
        existing.setMedicines(prescriptionDTO.getMedicines());
        existing.setPrescribedBy(doctor.getName());
        existing.setPatientName(patient.getName());
        existing.setNextVisitDate(prescriptionDTO.getNextVisitDate());
        prescriptionRepository.save(existing);
        return prescriptionMapper.toDTO(prescriptionRepository.save(existing));
    }




    @Transactional
    public void deletePrescription(Long id) {

        Prescription pres = prescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found with id: " + id));

        prescriptionRepository.delete(pres);

    }

    @Override
    public List<PrescriptionDTO> getByDate(LocalDate date) {

        List<Prescription> prescriptions = prescriptionRepository.findByPrescriptionDate(date);
        List<PrescriptionDTO> prescriptionDTOS = prescriptionMapper.convertAllToDTO(prescriptions);
        for (PrescriptionDTO prescriptionDTO : prescriptionDTOS) {
            Doctor doctor1 = doctorRepository.findById(prescriptionDTO.getDoctor_id()).orElseThrow();
            prescriptionDTO.setPrescribedBy(doctor1.getName());
        }
        return prescriptionDTOS ;
    }

    @Override
    public List<PrescriptionDTO> getLastMonthPrescription() {

        String loggedInEmail = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        Doctor doctor = doctorRepository.findByEmail(loggedInEmail)
                .orElseThrow(() -> new RuntimeException("Logged-in doctor not found: " + loggedInEmail));

        LocalDate today = LocalDate.now();
        LocalDate startOfLastMonth =today.minusDays(30);

        List<Prescription>  prescriptions =  prescriptionRepository.findByDoctorIdAndPrescriptionDateBetween(doctor.getId(), startOfLastMonth, today);
        List<PrescriptionDTO> prescriptionDTOS = prescriptionMapper.convertAllToDTO(prescriptions);
        for (PrescriptionDTO prescriptionDTO : prescriptionDTOS) {
            Doctor doctor1 = doctorRepository.findById(prescriptionDTO.getDoctor_id()).orElseThrow();
            prescriptionDTO.setPrescribedBy(doctor1.getName());
        }
        return prescriptionDTOS ;
    }

    @Override
    public List<PrescriptionDTO> getPrescriptionsByLoggedInDoctor() {

        String loggedInEmail = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        Doctor doctor = doctorRepository.findByEmail(loggedInEmail)
                .orElseThrow(() -> new RuntimeException("Logged-in doctor not found: " + loggedInEmail));


        List<Prescription> prescriptions = prescriptionRepository.findByDoctor_Id(doctor.getId());

        List<PrescriptionDTO> prescriptionDTOS = prescriptionMapper.convertAllToDTO(prescriptions);
        for (PrescriptionDTO prescriptionDTO : prescriptionDTOS) {
            Doctor doctor1 = doctorRepository.findById(prescriptionDTO.getDoctor_id()).orElseThrow();
            prescriptionDTO.setPrescribedBy(doctor1.getName());
        }
        return prescriptionDTOS ;
    }

    @Transactional
    public void deleteById(Long id) {
        Prescription pres = prescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found: " + id));
        prescriptionRepository.delete(pres);
    }

    @Override
    public List<DayWisePrescriptionCountDTO> getDayWisePrescriptionCount() {
        String loggedInEmail = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        Doctor doctor = doctorRepository.findByEmail(loggedInEmail)
                .orElseThrow(() -> new RuntimeException("Logged-in doctor not found: " + loggedInEmail));
        System.out.println(doctor.getId());
        List<Object[]> raw = prescriptionRepository.findDayWiseCountByDoctor(doctor.getId());

        List<DayWisePrescriptionCountDTO> result = new ArrayList<>();
        for (Object[] arr : raw) {
            LocalDate day = (arr[0] == null) ? null : (LocalDate) arr[0];
            Long count = (arr[1] == null) ? 0L : (Long) arr[1];
            result.add(new DayWisePrescriptionCountDTO(day, count));
        }
        return result;


    }

    @Override
    public List<PrescriptionDTO> getPrescriptionSearchByFromDateToDate(LocalDate from,
                                                                       LocalDate to){
        String loggedInEmail = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        Doctor doctor = doctorRepository.findByEmail(loggedInEmail)
                .orElseThrow(() -> new RuntimeException("Logged-in doctor not found: " + loggedInEmail));

        List<Prescription> prescriptions = prescriptionRepository.findByDoctorIdAndPrescriptionDateBetween(doctor.getId(), from, to);
        List<PrescriptionDTO> prescriptionDTOS = prescriptionMapper.convertAllToDTO(prescriptions);
        for (PrescriptionDTO prescriptionDTO : prescriptionDTOS) {
            Doctor doctor1 = doctorRepository.findById(prescriptionDTO.getDoctor_id()).orElseThrow();
            prescriptionDTO.setPrescribedBy(doctor1.getName());
        }
        return prescriptionDTOS ;
    }

}

