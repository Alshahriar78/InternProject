package org.healthcare.AppointmentBooking.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.healthcare.AppointmentBooking.model.dto.DoctorAppointmentDTO;
import org.healthcare.AppointmentBooking.model.entity.DoctorAppointment;
import org.healthcare.AppointmentBooking.service.DoctorAppointmentService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class DoctorAppointmentController {


    private final DoctorAppointmentService doctorAppointmentService;

    @GetMapping("/book")
    public String showAppointmentForm(Model model) {
        return "users/appointment_form";
    }

    @PostMapping("/book")
    public String processAppointment(
            @Valid @ModelAttribute("doctorAppointmentDTO") DoctorAppointmentDTO doctorAppointmentDTO,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "users/confirmation";
        }
        doctorAppointmentService.bookAppointment(doctorAppointmentDTO);
        model.addAttribute("successMessage", "Doctor Appointment successful!");
        return "redirect:/dashboard?success";
    }

    @DeleteMapping("/delete/{id}")
    public DoctorAppointment deleteAppointment(@PathVariable Long id) {
       return doctorAppointmentService.deleteAppointmentByID(id);
    }
}

