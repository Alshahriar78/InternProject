package org.healthcare.AppointmentBooking.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.healthcare.AppointmentBooking.model.dto.UsersDTO;
import org.healthcare.AppointmentBooking.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    // 1) Show the empty registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDto", new UsersDTO());
        return "users/register";  // src/main/resources/templates/users/register.html
    }

    // 2) Process the submitted form
    @PostMapping("/register")
    public String processRegistration(
            @Valid @ModelAttribute("userDto") UsersDTO userDto,
            BindingResult bindingResult,
            Model model) {

        // If validation errors, redisplay form
        if (bindingResult.hasErrors()) {
            return "users/register";
        }

        // Otherwise register and redirect to success page or back with flag
        usersService.register(userDto);
        return "redirect:/users/register?success";
    }
}
