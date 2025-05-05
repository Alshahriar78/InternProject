package org.healthcare.AppointmentBooking.repository;


import org.healthcare.AppointmentBooking.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsersRepository extends JpaRepository<Users, Long> {
}
