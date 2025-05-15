package org.healthcare.AppointmentBooking.repository;

import org.healthcare.AppointmentBooking.model.entity.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabTestRepository extends JpaRepository<LabTest, Long> {

     List<LabTest> findByLabTestNameContainingIgnoreCase(String name);

}
