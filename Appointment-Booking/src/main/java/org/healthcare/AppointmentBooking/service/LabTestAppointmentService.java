package org.healthcare.AppointmentBooking.service;

import org.healthcare.AppointmentBooking.model.dto.LabTestAppointmentDTO;
import org.healthcare.AppointmentBooking.model.entity.LabTestAppointment;
import org.healthcare.AppointmentBooking.model.entity.Users;
import org.healthcare.AppointmentBooking.repository.LabTestAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LabTestAppointmentService {

    @Autowired
    private LabTestAppointmentRepository labTestAppointmentRepository;
    @Autowired
    private LabTestAppointmentService labTestAppointmentService;

    public LabTestAppointment labTestAppointment(LabTestAppointmentDTO labTestAppointmentDTO
                                                ) {
        return null;
     }
}

