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


}
