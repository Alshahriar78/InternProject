package org.healthcare.AppointmentBooking.controller;

import org.healthcare.AppointmentBooking.config.JwtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;


@Controller
public class AuthenticationController {

    private final JwtUtil jwtUtil;

    public AuthenticationController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // check username and password
        if ("validUsername".equals(username) && "validPassword".equals(password)) {

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("token", jwtUtil.generateToken(username));
            return "users/dashboard";//
        }
        return "redirect:/login?error";
    }



    @GetMapping("/login")
    public String loginPage() {
        return "users/login"; // login.html (Thymeleaf view)
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "users/logout"; // Optional page
    }
}
