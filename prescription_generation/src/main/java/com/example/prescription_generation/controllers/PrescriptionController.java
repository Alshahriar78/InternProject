package com.example.prescription_generation.controllers;


import com.example.prescription_generation.model.dto.PrescriptionDTO;
import com.example.prescription_generation.model.entity.precription.Prescription;
import com.example.prescription_generation.service.PrescriptionService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API/v1/prescription")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("/create")
    public String createPrescription(@RequestBody PrescriptionDTO prescriptionDTO){
        try{
           prescriptionService.createPrescription(prescriptionDTO);
           return "Prescription created successfully";
        } catch (Exception e){
            System.out.println(e.getMessage());
            return "Prescription creation failed";

        }

    }

}
