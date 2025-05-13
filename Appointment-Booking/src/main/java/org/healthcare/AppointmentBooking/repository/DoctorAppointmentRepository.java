package org.healthcare.AppointmentBooking.repository;

import org.healthcare.AppointmentBooking.model.entity.DoctorAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, Long> {
    // আপনি যদি কাস্টম কুয়েরি চান তবে এখানে যোগ করতে পারবেন
}
