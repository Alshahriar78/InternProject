package org.healthcare.AppointmentBooking.service;


import org.healthcare.AppointmentBooking.model.entity.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.healthcare.AppointmentBooking.model.dto.LabDTO;
import org.healthcare.AppointmentBooking.repository.LabRepository;
import org.healthcare.AppointmentBooking.model.mapper.LabMapper;

@Service
public class LabService {

    @Autowired
    private LabRepository labRepository;


    public String addLab(LabDTO labDTO){
        LabMapper labMapper = new LabMapper();
        Lab lab = labMapper.toEntity(labDTO);
        labRepository.save(lab);
        return " Lab added successfully" ;
    }
}
