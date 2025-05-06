package org.healthcare.AppointmentBooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    // Dashboard endpoint, accessible after login
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "users/dashboard"; // This refers to the dashboard.html template in Thymeleaf
    }
}
