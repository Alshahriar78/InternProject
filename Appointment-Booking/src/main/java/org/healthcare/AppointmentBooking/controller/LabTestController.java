package org.healthcare.AppointmentBooking.controller;

import lombok.RequiredArgsConstructor;
import org.healthcare.AppointmentBooking.model.dto.LabTestDTO;
import org.healthcare.AppointmentBooking.model.entity.LabTest;
import org.healthcare.AppointmentBooking.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lab-test")
public class LabTestController {


    private final LabTestService labTestService;

    @PostMapping("/create")
    public String  createLabTest(@RequestBody LabTestDTO labTestDTO) {
         labTestService.createLabTest(labTestDTO);
         return "Lab Test created successfully  By Admin";
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<LabTestDTO>> getAllLabTests() {
        return ResponseEntity.ok(labTestService.getAllLabTests());
    }

    @GetMapping("/search")
    public ResponseEntity<List<LabTest>> searchLabTests(@RequestParam String keyword) {
        List<LabTest> results = labTestService.searchLabTest(keyword);
        return ResponseEntity.ok(results);
    }



}

