package org.healthcare.AppointmentBooking.repository;

import org.healthcare.AppointmentBooking.model.entity.LabTestAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestAppointmentRepository extends JpaRepository<LabTestAppointment , Long> {

}
