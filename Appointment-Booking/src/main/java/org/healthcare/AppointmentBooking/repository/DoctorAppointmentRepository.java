package org.healthcare.AppointmentBooking.repository;

import org.healthcare.AppointmentBooking.model.entity.DoctorAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, Long> {

    // Find all appointments for a specific user
    List<DoctorAppointment> findByUserId(Long userId);
    // Find all appointments for a specific doctor
    List<DoctorAppointment> findByDoctorId(Long doctorId);
    // Find all appointments for a specific doctor and user
    List<DoctorAppointment> findByDoctorIdAndUserId(Long doctorId, Long userId);


}
