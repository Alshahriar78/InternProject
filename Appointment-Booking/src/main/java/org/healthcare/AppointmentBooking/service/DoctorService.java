package org.healthcare.AppointmentBooking.service;

import org.healthcare.AppointmentBooking.model.dto.DoctorDTO;
import org.healthcare.AppointmentBooking.model.entity.Doctor;
import org.healthcare.AppointmentBooking.model.mapper.DoctorsMapper;
import org.healthcare.AppointmentBooking.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> searchDoctors(String keyword) {
        return doctorRepository.findByNameContainingIgnoreCaseOrSpecializationContainingIgnoreCase(keyword, keyword);
    }

    public List<Doctor> getAllDoctorsList() {
        return doctorRepository.findAll();
    }

    public String saveDoctor(DoctorDTO doctorDTO) {
        DoctorsMapper doctorsMapper = new DoctorsMapper();
        Doctor  doctor = doctorsMapper.toEntity(doctorDTO);
         doctorRepository.save(doctor);
        return "Doctor saved successfully";
    }

    public String deleteDoctor(Long id) {
        if (id != null) {
            doctorRepository.deleteById(id);
            return "Doctor deleted successfully";
        } else {
            throw new RuntimeException("Doctor not found with id: " + id);
        }
    }


    public String updateDoctorInformation(Long id, DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        if (id == null) {
            throw new RuntimeException("Doctor not found with id: " + id);
        }
        doctor = doctorRepository.findById(id).orElseThrow();
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setName(doctorDTO.getDoctorName());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setImage(doctorDTO.getImage());
        doctorRepository.save(doctor);
        return "Doctor updated successfully";
    }
}
