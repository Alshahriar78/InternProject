package org.healthcare.AppointmentBooking.controller;

import lombok.RequiredArgsConstructor;
import org.healthcare.AppointmentBooking.model.dto.DoctorDTO;
import org.healthcare.AppointmentBooking.model.entity.Doctor;
import org.healthcare.AppointmentBooking.model.mapper.DoctorsMapper;
import org.healthcare.AppointmentBooking.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    @Autowired
    private final DoctorService doctorService;
    private final DoctorsMapper doctorsMapper;

    @GetMapping("/search")
    public List<Doctor> searchDoctors(@RequestParam String keyword ) {
        return  doctorService.searchDoctors(keyword);
    }

    @PostMapping("/register")
    public String registerDoctor(@RequestBody DoctorDTO doctorDTO) {
        return doctorService.saveDoctor(doctorDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
       return doctorService.deleteDoctor(id);
    }

    @PatchMapping("/update/{id}")
    public String updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO) {
        Doctor doctor = doctorsMapper.toEntity(doctorDTO);
        doctor.setId(id);
        return doctorService.updateDoctorInformation(id, doctorDTO);
    }
}

