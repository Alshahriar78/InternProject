package org.healthcare.AppointmentBooking.controller;

import lombok.RequiredArgsConstructor;
import org.healthcare.AppointmentBooking.service.DashBoardService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class DashBoardController {
    private final DashBoardService dashBoardService;

    @GetMapping("/dashboard")
    public String getDashboard(Authentication authentication, Model model, 
                              @RequestParam(name = "keyword", required = false) String keyword) {
        Map<String, Object> dashboardData = dashBoardService.getDashboardData(authentication, keyword);
        dashboardData.forEach(model::addAttribute);
        return "users/dashboard";
    }
}
