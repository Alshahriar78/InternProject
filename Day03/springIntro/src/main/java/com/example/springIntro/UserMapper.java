package com.example.springIntro;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User map(UserDTO dto) {

        User user = new User();

        user.setName(dto.getName());

        user.setEmail(dto.getEmail());

        user.setPhoneNumber(dto.getPhoneNumber());



        return user;
    }
    public  UserDTO map(User entity) {
        UserDTO dto = new UserDTO();

        dto.setName(entity.getName());

        dto.setEmail(entity.getEmail());

        dto.setPhoneNumber(entity.getPhoneNumber());


        return dto;
    }
}
