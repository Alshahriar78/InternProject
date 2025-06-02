
package com.example.prescription_generation.controllers;


import com.example.prescription_generation.model.dto.PrescriptionDTO;
import com.example.prescription_generation.model.entity.precription.Prescription;
import com.example.prescription_generation.service.PrescriptionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API/V1/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("/save")
    public String savePrescription(@RequestBody PrescriptionDTO prescriptionDTO){
        try{
            prescriptionService.savePrescription(prescriptionDTO);
            return "Prescription saved successfully";
        }catch(Exception e){
            return "Error";
        }
    }

    @GetMapping("/{id}")
    public PrescriptionDTO getPrescriptionById(@PathVariable Long id){
        return prescriptionService.getPrescriptionById(id);
    }

    @GetMapping("/all")
    public Iterable<PrescriptionDTO> getAllPrescriptions(){
        return prescriptionService.getAllPrescriptions();
    }

    @PatchMapping("/update/{id}")
    public PrescriptionDTO updatePrescription(@PathVariable Long id, @RequestBody PrescriptionDTO prescriptionDTO){
        return prescriptionService.updatePrescription(id, prescriptionDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePrescription(@PathVariable Long id){
        prescriptionService.deletePrescription(id);
    }
}