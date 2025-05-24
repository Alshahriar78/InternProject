package org.healthcare.AppointmentBooking.service;


import lombok.RequiredArgsConstructor;
import org.healthcare.AppointmentBooking.model.dto.DoctorAppointmentDTO;
import org.healthcare.AppointmentBooking.model.dto.UsersDTO;
import org.healthcare.AppointmentBooking.model.entity.Doctor;
import org.healthcare.AppointmentBooking.model.entity.DoctorAppointment;
import org.healthcare.AppointmentBooking.model.entity.Users;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashBoardService {

    private final UsersService usersService;
    private final DoctorService doctorService;
    private final DoctorAppointmentService doctorAppointmentService;


    public Map<String, Object> getDashboardData(Authentication authentication, String keyword) {
        String username = authentication.getName();
        UsersDTO usersDTO = usersService.showDashboardByUsername(username);
        Users user = usersService.getUserByEmail(username);

        List<Doctor> doctors;
        if (keyword != null && !keyword.isEmpty()) {
            doctors = doctorService.searchDoctors(keyword);
        } else {
            doctors = doctorService.getAllDoctorsList();
        }

        List<DoctorAppointment> appointments = doctorAppointmentService.findByUserId(user.getId());
        Map<String, Object> dashboardData = new HashMap<>();
        dashboardData.put("userDto", usersDTO);
        dashboardData.put("doctorAppointmentDTO", new DoctorAppointmentDTO());
        dashboardData.put("doctor", doctors);
        dashboardData.put("listAppointment", appointments);
        dashboardData.put("keyword", keyword);
        return dashboardData;
    }
}
