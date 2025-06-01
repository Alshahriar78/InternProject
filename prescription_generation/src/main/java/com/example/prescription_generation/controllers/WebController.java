package com.example.prescription_generation.controllers;

import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.example.prescription_generation.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    @Autowired
    private UserRegistrationService userRegistrationService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(
            @RequestParam("userType") String userType,
            @RequestParam("name") String name,
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("password") String password,
            @RequestParam(value = "specialist", required = false) String specialist,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "bloodGroup", required = false) String bloodGroup,
            @RequestParam(value = "address", required = false) String address,
            RedirectAttributes redirectAttributes) {

        try {
            if ("doctor".equals(userType)) {
                Doctor doctor = new Doctor();
                doctor.setName(name);
                doctor.setUsername(username);
                doctor.setEmail(email);
                doctor.setPhoneNumber(phoneNumber);
                doctor.setPassword(password);
                doctor.setSpecialist(specialist);

                userRegistrationService.registerDoctor(doctor);
            } else if ("patient".equals(userType)) {
                Patient patient = new Patient();
                patient.setName(name);
                patient.setUsername(username);
                patient.setEmail(email);
                patient.setPhoneNumber(phoneNumber);
                patient.setPassword(password);
                patient.setAge(age != null ? age : 0);
                patient.setGender(gender);
                patient.setBloodGroup(bloodGroup);
                patient.setAddress(address);

                userRegistrationService.registerPatient(patient);
            }

            redirectAttributes.addAttribute("success", "true");
            return "redirect:/login";
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", e.getMessage());
            return "redirect:/register";
        }
    }


    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "dashboard";
    }
}
