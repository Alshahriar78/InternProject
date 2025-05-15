package org.healthcare.AppointmentBooking.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.healthcare.AppointmentBooking.config.CustomUserDetails;
import org.healthcare.AppointmentBooking.model.dto.DoctorDTO;
import org.healthcare.AppointmentBooking.model.entity.Doctor;
import org.healthcare.AppointmentBooking.model.entity.Users;
import org.healthcare.AppointmentBooking.model.mapper.UsersMapper;
import org.healthcare.AppointmentBooking.repository.UsersRepository;
import org.healthcare.AppointmentBooking.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    @Autowired
    private final DoctorService doctorService;


    @GetMapping("/getAll")
    public String getAllDoctors( Model model) {
        model.addAttribute("doctor",doctorService.getAllDoctors());
         return "users/dashboard";
    }
    @GetMapping("/search")
    public String searchDoctors(@RequestParam String keyword ,
                                                      Model model) {
        model.addAttribute("doctor_seach",doctorService.searchDoctors(keyword));
        return "users/dashboard";
    }

    @PostMapping("/register")
    public String registerDoctor(@RequestBody DoctorDTO doctorDTO) {
        System.out.println("Doctor Details"+doctorDTO);
        return doctorService.saveDoctor(doctorDTO);// Redirect to doctor list or profile page
    }
}

