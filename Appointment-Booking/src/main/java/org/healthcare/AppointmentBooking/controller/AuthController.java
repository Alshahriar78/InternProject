package org.healthcare.AppointmentBooking.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "users/login"; // login.html (Thymeleaf view)
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "users/logout"; // Optional page
    }
}
