package org.healthcare.AppointmentBooking.service;

import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.healthcare.AppointmentBooking.model.dto.DoctorAppointmentDTO;
import org.healthcare.AppointmentBooking.model.entity.DoctorAppointment;
import org.healthcare.AppointmentBooking.model.mapper.DoctorAppointmentMapper;
import org.healthcare.AppointmentBooking.model.mapper.DoctorsMapper;
import org.healthcare.AppointmentBooking.repository.DoctorAppointmentRepository;
import org.healthcare.AppointmentBooking.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorAppointmentService {

    @Autowired
    private DoctorAppointmentRepository doctorAppointmentRepository;

    @Autowired
    private DoctorAppointmentMapper doctorAppointmentMapper;
    @Autowired
    private UsersRepository usersRepository;


    public void bookAppointment(@Valid DoctorAppointmentDTO doctorAppointmentDTO) {
        DoctorAppointment doctorAppointment = new DoctorAppointment();
        doctorAppointment = doctorAppointmentMapper.toEntity(doctorAppointmentDTO);
        doctorAppointmentRepository.save(doctorAppointment);  // Save the appointment
        System.out.println("Appointment saved successfully");
    }

    public DoctorAppointment getAppointmentById(Long id) {
  DoctorAppointment doctorAppointment = doctorAppointmentRepository.findById(id).orElseThrow();
        return doctorAppointment;
    }

    public List<DoctorAppointment> findByUserId(Long userId) {
        return doctorAppointmentRepository.findByUserId(userId);
    }


    public DoctorAppointment deleteAppointmentByID(Long id) {
        DoctorAppointment doctorAppointment = doctorAppointmentRepository.findById(id).orElseThrow();
        doctorAppointmentRepository.deleteById(id);
        return doctorAppointment;
    }
}
