package com.example.springIntro.model.mapper;

import com.example.springIntro.model.dto.UserDTO;
import com.example.springIntro.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserDTO dto) {

        User user = new User();

        user.setName(dto.getName());

        user.setEmail(dto.getEmail());

        user.setPhoneNumber(dto.getPhoneNumber());



        return user;
    }
    public  UserDTO toDTO(User entity) {
        UserDTO dto = new UserDTO();

        dto.setName(entity.getName());

        dto.setEmail(entity.getEmail());

        dto.setPhoneNumber(entity.getPhoneNumber());


        return dto;
    }
}
