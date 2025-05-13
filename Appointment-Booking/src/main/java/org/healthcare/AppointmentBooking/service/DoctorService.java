package org.healthcare.AppointmentBooking.service;

import org.healthcare.AppointmentBooking.model.dto.DoctorDTO;
import org.healthcare.AppointmentBooking.model.entity.Doctor;
import org.healthcare.AppointmentBooking.model.mapper.DoctorsMapper;
import org.healthcare.AppointmentBooking.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> searchDoctors(String keyword) {
        return doctorRepository.findByNameContainingIgnoreCaseOrSpecializationContainingIgnoreCase(keyword, keyword);
    }

    // Method to get a doctor by ID
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);  // Fetch doctor by ID
    }

    // Method to save a new doctor
    public String saveDoctor(DoctorDTO doctorDTO) {
    System.out.println("Doctor Details"+doctorDTO+" from service");
        DoctorsMapper doctorsMapper = new DoctorsMapper();
        Doctor  doctor = doctorsMapper.toEntity(doctorDTO);
         doctorRepository.save(doctor);
        return "Doctor saved successfully";

    }

    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorRepository.findAll());
    }
}
