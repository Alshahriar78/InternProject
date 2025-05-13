package org.healthcare.AppointmentBooking.controller;

import org.healthcare.AppointmentBooking.model.dto.LabTestDTO;
import org.healthcare.AppointmentBooking.model.entity.LabTest;
import org.healthcare.AppointmentBooking.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lab-tests")
public class LabTestController {

    @Autowired
    private LabTestService labTestService;

    @PostMapping("/create")
    public ResponseEntity<LabTestDTO> createLabTest(@RequestBody LabTestDTO labTestDTO) {
        return ResponseEntity.ok(labTestService.createLabTest(labTestDTO));
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

