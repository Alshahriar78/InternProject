package org.healthcare.AppointmentBooking.model.mapper;

import org.healthcare.AppointmentBooking.model.dto.LabTestAppointmentDTO;
import org.healthcare.AppointmentBooking.model.entity.LabTestAppointment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LabTestAppointmentMapper {

//    public LabTestAppointment toEntity( LabTestAppointmentDTO labTestAppointmentDTO){
//        if(labTestAppointmentDTO == null) return null;
//        LabTestAppointment labTestAppointment = new LabTestAppointment();
//        labTestAppointment.setAppointmentDate(LocalDateTime.now());
//        labTestAppointment.setNote(labTestAppointmentDTO.getNote());
//        return null;
//    }
//
//    public LabTestAppointmentDTO toDto(LabTestAppointment labTestAppointment){
//        if(labTestAppointment == null) return null;
//        LabTestAppointmentDTO labTestAppointmentDTO = new LabTestAppointmentDTO();
//        labTestAppointmentDTO.setNote(labTestAppointment.getNote());
//        labTestAppointmentDTO.setAppointmentDate(labTestAppointment.getAppointmentDate());
//        return labTestAppointmentDTO;
//    }

}
