package org.healthcare.AppointmentBooking.controller;

import lombok.RequiredArgsConstructor;
import org.healthcare.AppointmentBooking.model.dto.LabDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.healthcare.AppointmentBooking.service.LabService;

@RestController
@RequestMapping("/lab")
@RequiredArgsConstructor
public class LabController {

    @Autowired
    private LabService labService;


    @PostMapping("/add")
    public String addLab(@RequestBody LabDTO labDTO) {
        return labService.addLab(labDTO);  // Return the added lab information to the client
    }

}
