package com.example.prescription_generation.controllers;

import com.example.prescription_generation.model.dto.PatientDTO;
import com.example.prescription_generation.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API/V1/patients")
public class PatientController {


    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public PatientDTO getPatientById(Long id){
        return patientService.getPatientById(id);
    }

    @GetMapping("/all")
    public Iterable<PatientDTO> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/search")
    public Iterable<PatientDTO> getPatientByName(@RequestParam String keyword){
        return patientService.getPatientByName(keyword);
    }

    @PatchMapping("/update/{id}")
    public PatientDTO updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO){
        return patientService.updatePatient(id, patientDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
    }

}
