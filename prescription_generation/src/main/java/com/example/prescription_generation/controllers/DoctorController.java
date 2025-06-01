package com.example.prescription_generation.controllers;




import com.example.prescription_generation.model.dto.DoctorDTO;
import com.example.prescription_generation.service.DoctorService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API/V1/doctors")
public class DoctorController {


    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoctorById(Long id){
        return doctorService.getDoctorById(id);
    }

    @GetMapping("/all")
    public Iterable<DoctorDTO> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @PatchMapping("/update/{id}")
    public DoctorDTO updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO){
        return doctorService.updateDoctor(id, doctorDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
    }

}
