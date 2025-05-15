package org.healthcare.AppointmentBooking.model.mapper;

import org.healthcare.AppointmentBooking.model.dto.LabDTO;
import org.healthcare.AppointmentBooking.model.entity.Lab;
import org.springframework.stereotype.Component;

@Component
public class LabMapper {

    // Convert DTO to Entity
    public Lab toEntity(LabDTO labDTO){
        if(labDTO == null) return null;
        Lab lab = new Lab();
        lab.setAddress(labDTO.getAddress());
        lab.setLabName(labDTO.getLabName());
        lab.setRating(labDTO.getRating());
        return lab;
    }

    // Convert Entity to DTO
    public LabDTO toDto(Lab lab){
        if(lab == null) return null;
        LabDTO labDTO = new LabDTO();
        labDTO.setLabName(lab.getLabName());
        labDTO.setAddress(lab.getAddress());
        labDTO.setRating(lab.getRating());
        return labDTO;
    }

}
