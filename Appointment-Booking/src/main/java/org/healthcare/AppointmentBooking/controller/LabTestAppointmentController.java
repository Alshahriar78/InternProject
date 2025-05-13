package org.healthcare.AppointmentBooking.controller;

import org.healthcare.AppointmentBooking.model.dto.LabTestAppointmentDTO;
import org.healthcare.AppointmentBooking.model.entity.LabTestAppointment;
import org.healthcare.AppointmentBooking.model.entity.Users;
import org.healthcare.AppointmentBooking.service.LabTestAppointmentService;
import org.healthcare.AppointmentBooking.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/test")
public class LabTestAppointmentController {

    @Autowired
    private LabTestAppointmentService labTestAppointmentService;
    @Autowired
    private UsersService usersService;

    @PostMapping("/book")
    public ResponseEntity<String> bookTestAppointment(@RequestBody LabTestAppointmentDTO labTestAppointmentDTO,
                                                     Authentication authentication) {
        Users users = (Users) authentication.getPrincipal();
        System.out.println("User Details"+users);
        return ResponseEntity.ok("Test Appointment booked successfully.");
    }
}

