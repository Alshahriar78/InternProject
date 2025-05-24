package org.healthcare.AppointmentBooking.model.mapper;

import org.healthcare.AppointmentBooking.model.dto.DoctorAppointmentDTO;
import org.healthcare.AppointmentBooking.model.entity.Doctor;
import org.healthcare.AppointmentBooking.model.entity.DoctorAppointment;
import org.healthcare.AppointmentBooking.model.entity.Users;
import org.healthcare.AppointmentBooking.repository.DoctorRepository;
import org.healthcare.AppointmentBooking.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;

@Component
public class DoctorAppointmentMapper {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    UsersRepository usersRepository;

    public DoctorAppointment toEntity(DoctorAppointmentDTO doctorAppointmentDTO){
        DoctorAppointment doctorAppointment = new DoctorAppointment();
        doctorAppointment.setNote(doctorAppointmentDTO.getNote());
        doctorAppointment.setAppointmentDate(doctorAppointmentDTO.getAppointmentDate());
        doctorAppointment.setAppointmentTime(doctorAppointmentDTO.getAppointmentTime());
        Doctor doctor1 = doctorRepository.findById(doctorAppointmentDTO.getDoctor_id()).get();
        System.out.println(doctor1);
        doctorAppointment.setDoctor( doctor1);
        Users users1 = usersRepository.findById(doctorAppointmentDTO.getPatient_id()).get();
        doctorAppointment.setUser(users1);
        System.out.println(users1);
        return doctorAppointment;
    }

    public DoctorAppointmentDTO toDto(DoctorAppointment doctorAppointment){
        DoctorAppointmentDTO doctorAppointmentDTO = new DoctorAppointmentDTO();
        doctorAppointmentDTO.setNote(doctorAppointment.getNote());
        doctorAppointmentDTO.setAppointmentDate(doctorAppointment.getAppointmentDate());
        doctorAppointmentDTO.setDoctor_id(doctorAppointment.getDoctor().getId());
        doctorAppointmentDTO.setPatient_id(doctorAppointment.getUser().getId());
        return doctorAppointmentDTO;
    }

}
