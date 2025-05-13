package org.healthcare.AppointmentBooking.repository;

import org.healthcare.AppointmentBooking.model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByEmail(String email);
    // Search by name or specialization (case-insensitive)
    List<Doctor> findByNameContainingIgnoreCaseOrSpecializationContainingIgnoreCase(String name, String specialization);

}
