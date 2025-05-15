package org.healthcare.AppointmentBooking.controller;

import jakarta.validation.Valid;
import org.healthcare.AppointmentBooking.model.dto.LabTestAppointmentDTO;
import org.healthcare.AppointmentBooking.service.LabTestAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@Controller
@RequestMapping("/api/test")
public class LabTestAppointmentController {

    @Autowired
    private LabTestAppointmentService labTestAppointmentService;

    @GetMapping("/appointments")
    public String   ShowBookTestAppointment(Model model) {
        model.addAttribute("labTestAppointmentDTO", new LabTestAppointmentDTO());
        return "users/labTestAppointment";
    }

    @PostMapping("/appointments")
    public String processBookTestAppointment(@Valid @ModelAttribute("labTestAppointmentDTO") LabTestAppointmentDTO labTestAppointmentDTO,
                                                             BindingResult bindingResult,
                                                             Model model) {
        if (bindingResult.hasErrors()) {
            return "Validation failed.";
        }
      labTestAppointmentService.labTestAppointment(labTestAppointmentDTO);
        model.addAttribute("successMessage",
                "Lab Test Appointment Booked successful!");
       return "redirect:/dashboard?success";
    }

}

