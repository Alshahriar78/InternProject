package org.healthcare.AppointmentBooking.model.mapper;

import org.healthcare.AppointmentBooking.model.dto.DoctorAppointmentDTO;
import org.healthcare.AppointmentBooking.model.entity.DoctorAppointment;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;

@Component
public class DoctorAppointmentMapper {

    public DoctorAppointment toEntity(DoctorAppointmentDTO doctorAppointmentDTO){
        DoctorAppointment doctorAppointment = new DoctorAppointment();
        doctorAppointment.setBookingDate(LocalDateTime.now());
        doctorAppointment.setAppointmentDate(doctorAppointmentDTO.getDate());


        return doctorAppointment;
    }
}
