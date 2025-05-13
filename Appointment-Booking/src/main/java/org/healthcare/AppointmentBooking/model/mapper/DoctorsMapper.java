package org.healthcare.AppointmentBooking.model.mapper;

import org.healthcare.AppointmentBooking.model.dto.DoctorDTO;
import org.healthcare.AppointmentBooking.model.entity.Doctor;
import org.springframework.stereotype.Component;


@Component
public class DoctorsMapper {

    // Convert Entity to DTO
    public DoctorDTO toDTO(Doctor doctor) {
        DoctorDTO dto = new DoctorDTO();
        dto.setDoctorName(doctor.getName());
        dto.setPhoneNumber(doctor.getPhoneNumber());
        dto.setEmail(doctor.getEmail());
        dto.setAddress(doctor.getAddress());
        dto.setGender(doctor.getGender());
        dto.setDateOfBirth(doctor.getDateOfBirth());
        dto.setQualification(doctor.getQualification());
        dto.setSpecialization(doctor.getSpecialization());
        dto.setExperience(doctor.getExperience());
        dto.setImage(doctor.getImage());
        return dto;
    }

    // Convert DTO to Entity
    public Doctor toEntity(DoctorDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setAddress(dto.getAddress());
        doctor.setDateOfBirth(dto.getDateOfBirth());
        doctor.setEmail(dto.getEmail());
        doctor.setExperience(dto.getExperience());
        doctor.setGender(dto.getGender());
        doctor.setImage(dto.getImage());
        doctor.setQualification(dto.getQualification());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setName(dto.getDoctorName());
        doctor.setPhoneNumber(dto.getPhoneNumber());
        return doctor;
    }
}

