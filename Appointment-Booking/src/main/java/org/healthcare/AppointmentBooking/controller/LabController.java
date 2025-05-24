package org.healthcare.AppointmentBooking.controller;

import lombok.RequiredArgsConstructor;
import org.healthcare.AppointmentBooking.model.dto.LabDTO;
import org.healthcare.AppointmentBooking.model.entity.Lab;
import org.springframework.web.bind.annotation.*;
import org.healthcare.AppointmentBooking.service.LabService;

import java.util.List;

@RestController
@RequestMapping("/lab")
@RequiredArgsConstructor
public class LabController {
    private final LabService labService;

    @PostMapping("/add")
    public String addLab(@RequestBody LabDTO labDTO) {
        return labService.addLab(labDTO);
    }
    @GetMapping("/search/{keyword}")
    public List<Lab> searchLab(@PathVariable String keyword) {
        return labService.searchLabByName(keyword);
    }

    @GetMapping("/all")
    public List<Lab> getAllLabs() {
        return labService.allLabs();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLab(@PathVariable Long id) {
        return labService.deleteLab(id);
    }

    @PatchMapping("/update/{id}")
    public String updateLab(@PathVariable Long id, @RequestBody LabDTO labDTO) {
        labService.updateLabInformation(id,labDTO);
        return "Lab updated successfully with id: " + id;
    }
}
