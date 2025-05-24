package org.healthcare.AppointmentBooking.repository;

import org.healthcare.AppointmentBooking.model.entity.Doctor;
import org.healthcare.AppointmentBooking.model.entity.Lab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface  LabRepository extends JpaRepository<Lab , Long> {
    List<Lab> findByLabNameContainingIgnoreCase(String labName);

}
