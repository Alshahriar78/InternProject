package org.healthcare.AppointmentBooking.repository;


import org.apache.catalina.User;
import org.healthcare.AppointmentBooking.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
}
