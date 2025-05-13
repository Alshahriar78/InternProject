package org.healthcare.AppointmentBooking.controller;


import org.healthcare.AppointmentBooking.model.entity.DoctorAppointment;
import org.healthcare.AppointmentBooking.service.DoctorAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointment")
public class DoctorAppointmentController {

    @Autowired
    private DoctorAppointmentService doctorAppointmentService;

    @PostMapping("/book")
    public String bookDoctorAppointment(@ModelAttribute DoctorAppointment doctorAppointment,
                                        Authentication authentication) {
         String userName = authentication.getName();
        doctorAppointmentService.bookDoctorAppointment(doctorAppointment, userName);
        return "redirect:/appointment/confirmation";  // Redirect to confirmation page
    }
}

