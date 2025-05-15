package org.healthcare.AppointmentBooking.service;

import lombok.AllArgsConstructor;
import org.healthcare.AppointmentBooking.model.dto.LabTestAppointmentDTO;
import org.healthcare.AppointmentBooking.model.dto.LabTestDTO;
import org.healthcare.AppointmentBooking.model.entity.LabTestAppointment;
import org.healthcare.AppointmentBooking.model.entity.Users;
import org.healthcare.AppointmentBooking.repository.DoctorRepository;
import org.healthcare.AppointmentBooking.repository.LabTestAppointmentRepository;
import org.healthcare.AppointmentBooking.repository.LabTestRepository;
import org.healthcare.AppointmentBooking.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class LabTestAppointmentService {
    @Autowired
    private LabTestAppointmentRepository labTestAppointmentRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private LabTestRepository labTestRepository;


    public LabTestAppointment labTestAppointment(
                                                  LabTestAppointmentDTO labTestAppointmentDTO){
        return   null;
     }
}

