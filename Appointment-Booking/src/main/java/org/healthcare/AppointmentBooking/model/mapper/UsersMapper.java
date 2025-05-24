package org.healthcare.AppointmentBooking.model.mapper;

import org.healthcare.AppointmentBooking.model.dto.UsersDTO;
import org.healthcare.AppointmentBooking.model.entity.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    private final PasswordEncoder passwordEncoder;

    public UsersMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // Convert Entity to DTO
    public UsersDTO toDTO(Users user) {
        UsersDTO dto = new UsersDTO();
        dto.setFullName(user.getFullName());
        dto.setMobileNumber(user.getMobileNumber());
        dto.setEmail(user.getEmail());
        dto.setGender(user.getGender());
        dto.setDateOfBirth(user.getDateOfBirth());
        return dto;
    }

    // Convert DTO to Entity
    public Users toEntity(UsersDTO dto) {
        Users user = new Users();
        user.setFullName(dto.getFullName());
        user.setMobileNumber(dto.getMobileNumber());
        user.setPassword(passwordEncoder.encode(dto.getPassword())); // DTO থেকে password নিতে হবে
        user.setEmail(dto.getEmail());
        user.setGender(dto.getGender());
        user.setDateOfBirth(dto.getDateOfBirth());
        return user;
    }
}
