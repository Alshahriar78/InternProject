package com.example.prescription_generation.controllers;


import com.example.prescription_generation.model.dto.PrescriptionDTO;
import com.example.prescription_generation.service.PrescriptionCreationImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API/v1/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionCreationImpl prescriptionCreationService;

    @PostMapping("/create")
    public String createPrescription(@RequestBody PrescriptionDTO prescriptionDTO){
        prescriptionCreationService.createPrescription(prescriptionDTO);
        return "Prescription created successfully";
    }

}
