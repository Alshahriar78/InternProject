package org.healthcare.AppointmentBooking.model.mapper;



import org.healthcare.AppointmentBooking.model.dto.UsersDTO;
import org.healthcare.AppointmentBooking.model.entity.Users;

import java.util.List;

public class UsersMapper {

    // Convert Entity to DTO
    public  UsersDTO toDTO(Users user) {
        UsersDTO dto = new UsersDTO();
        dto.setFullName(user.getFullName());
        dto.setMobileNumber(user.getMobileNumber());
        user.setPassword(user.getPassword());

        dto.setEmail(user.getEmail());
        dto.setGender(user.getGender());
        dto.setDateOfBirth(user.getDateOfBirth());
        return dto;
    }

    // Convert DTO to Entity
    public  Users toEntity(UsersDTO dto) {
        Users user = new Users();
        user.setFullName(dto.getFullName());
        user.setMobileNumber(dto.getMobileNumber());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setGender(dto.getGender());
        user.setDateOfBirth(dto.getDateOfBirth());
//        user.setRoles(dto.getRoles());
//        user.setId(dto.getId());
        return user;
    }
}
