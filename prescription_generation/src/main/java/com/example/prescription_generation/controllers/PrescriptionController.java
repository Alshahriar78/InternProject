
package com.example.prescription_generation.controllers;


import com.example.prescription_generation.model.dto.PrescriptionDTO;
import com.example.prescription_generation.service.PrescriptionService;
import com.example.prescription_generation.service.PrescriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/API/V1/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;
    @Autowired
    private PrescriptionServiceImpl prescriptionServiceImpl;

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

     // GET /prescriptions/by-date?date=2025-06-03
    @GetMapping("/by-date")
    public ResponseEntity<List<PrescriptionDTO>> findByDate(
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        List<PrescriptionDTO> prescriptionsOnDate = prescriptionService.getByDate(date);
        if (prescriptionsOnDate.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(prescriptionsOnDate);
    }

    @GetMapping("/last-month")
    public ResponseEntity<List<PrescriptionDTO>> findLastMonth() {
        List<PrescriptionDTO> results = prescriptionService.getLastMonthPrescription();
        System.out.println(results.size()+ " results found");
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(results);
    }
}