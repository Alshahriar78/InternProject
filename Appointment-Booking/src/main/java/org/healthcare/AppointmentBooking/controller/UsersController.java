package org.healthcare.AppointmentBooking.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.healthcare.AppointmentBooking.model.dto.UsersDTO;
import org.healthcare.AppointmentBooking.model.entity.Doctor;
import org.healthcare.AppointmentBooking.model.entity.Users;
import org.healthcare.AppointmentBooking.repository.DoctorRepository;
import org.healthcare.AppointmentBooking.repository.UsersRepository;
import org.healthcare.AppointmentBooking.service.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    private final UsersRepository usersRepository;
    private final DoctorRepository doctorRepository;

    @GetMapping("/register")
        public String showRegistrationForm(Model model) {
            model.addAttribute("userDto", new UsersDTO());
            return "users/register";
        }


        @PostMapping("/register")
        public String processRegistration(
                @Valid @ModelAttribute("userDto") UsersDTO userDto,
                BindingResult result,
                Model model) {

            if (result.hasErrors()) {
                return "users/register";
            }

            usersService.register(userDto);
            return "redirect:/users/register?success";
        }

    // Dashboard endpoint, accessible after login
    @GetMapping("/dashboard")
    public String getDashboard(Authentication authentication ,
                               Model model) {
        String username = authentication.getName();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        List<Doctor> list =doctorRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ": " + list.get(i).getName());
            model.addAttribute("name",list.get(i).getName());
            System.out.println(i + ": " + list.get(i).getEmail());
            model.addAttribute("email",list.get(i).getEmail());
        }
      model.addAttribute("doctor",list);
        UsersDTO dto = usersService.showDashboardByUsername(username);
        model.addAttribute("userDto", dto);
        return "users/dashboard";
    }


    @GetMapping("/update/{id}")
    public String updateProfile(@PathVariable Long id, @RequestBody UsersDTO usersDTO) {
        Users updatedUser = usersService.updateUserProfile(id, usersDTO);
        return "users/updateProfile"   ;  // Return updated user information
    }


    @PatchMapping("/update/{id}")
    public String updateProfile(
            @PathVariable Long id,
            @Valid @ModelAttribute("userDto") UsersDTO userDto,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "users/updateProfile";
        }

        usersService.updateUserProfile(id,userDto);
        return "redirect:/users/dashboard?success";
    }


}
