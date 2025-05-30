package com.example.prescription_generation.controllers;



import com.example.prescription_generation.model.dto.DoctorDTO;
import com.example.prescription_generation.service.DoctorCreationServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private DoctorCreationServiceImpl doctorCreationService;

    public DoctorController(DoctorCreationServiceImpl doctorCreationService) {
        this.doctorCreationService = doctorCreationService;
    }

    @PostMapping("/register")
    public String registerDoctor(@RequestBody DoctorDTO doctorDTO) {
        doctorCreationService.registerDoctor(doctorDTO);
        return "Doctor registered successfully";
    }

}
