package org.healthcare.AppointmentBooking.repository;

import org.healthcare.AppointmentBooking.model.entity.Lab;
import org.springframework.data.jpa.repository.JpaRepository;


public interface  LabRepository extends JpaRepository<Lab , Long> {

}