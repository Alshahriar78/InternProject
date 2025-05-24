package org.healthcare.AppointmentBooking.service;


import lombok.RequiredArgsConstructor;
import org.healthcare.AppointmentBooking.model.entity.Lab;
import org.springframework.stereotype.Service;
import org.healthcare.AppointmentBooking.model.dto.LabDTO;
import org.healthcare.AppointmentBooking.repository.LabRepository;
import org.healthcare.AppointmentBooking.model.mapper.LabMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabService {


    private final LabRepository labRepository;


    public String addLab(LabDTO labDTO){
        LabMapper labMapper = new LabMapper();
        Lab lab = labMapper.toEntity(labDTO);
        labRepository.save(lab);
        return " Lab added successfully" ;
    }

    public List<Lab>  searchLabByName(String keyword) {
        return labRepository.findByLabNameContainingIgnoreCase(keyword);
    }

    public List<Lab> allLabs() {
        return labRepository.findAll();
    }

    public String deleteLab(Long id) {
        if (id != null) {
            labRepository.deleteById(id);
            return "Lab deleted successfully";
        } else {
            throw new RuntimeException("Lab not found with id: " + id);
        }
    }

    public String updateLabInformation(Long id, LabDTO labDTO) {
        Lab lab = new Lab();
        if (id == null) {
            throw new RuntimeException("Lab not found with id: " + id);
        }
        lab = labRepository.findById(id).orElseThrow();
        lab.setLabName(labDTO.getLabName());
        lab.setAddress(labDTO.getAddress());
        lab.setRating(labDTO.getRating());
        return labRepository.save(lab).toString();
    }
}
