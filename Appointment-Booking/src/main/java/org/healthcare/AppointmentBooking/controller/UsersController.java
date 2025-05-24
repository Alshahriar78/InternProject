package org.healthcare.AppointmentBooking.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.healthcare.AppointmentBooking.config.JwtUtil;
import org.healthcare.AppointmentBooking.model.dto.UsersDTO;
import org.healthcare.AppointmentBooking.model.entity.Users;
import org.healthcare.AppointmentBooking.service.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller

@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/register")
        public String showRegistrationForm(Model model) {
        model.addAttribute("userDto", new UsersDTO());
        return "users/register";
    }
    @PostMapping("/register")
    public String processRegistration(
            @Valid @ModelAttribute("userDto") UsersDTO userDto,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "users/register";
        }
        usersService.register(userDto);
        model.addAttribute("successMessage", "Registration successful!");
        return "redirect:/login?success";
    }

    @GetMapping("/update/")
    public String updateProfile(Model model, Authentication authentication) {
        String userEmail = authentication.getName();
        UsersDTO userDto = usersService.showDashboardByUsername(userEmail);
        model.addAttribute("userDto", userDto);
        return "users/updateProfile";
    }

    @PatchMapping("/update/")
    public String updateProfile(
            @Valid @ModelAttribute("userDto") UsersDTO userDto,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "users/updateProfile";
        }
        usersService.updateUserProfile(userDto);
        return "redirect:/dashboard?success";
    }
}
