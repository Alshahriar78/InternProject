package org.healthcare.AppointmentBooking.service;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.healthcare.AppointmentBooking.model.entity.DoctorAppointment;
import org.healthcare.AppointmentBooking.repository.DoctorAppointmentRepository;
import org.healthcare.AppointmentBooking.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorAppointmentService {

    @Autowired
    private DoctorAppointmentRepository doctorAppointmentRepository;
    @Autowired
    private UsersRepository usersRepository;


    public DoctorAppointment bookDoctorAppointment(DoctorAppointment doctorAppointment,String userName) {
        System.out.println(usersRepository.findByEmail(userName));
        return doctorAppointmentRepository.save(doctorAppointment);  // Save the appointment
    }
}

