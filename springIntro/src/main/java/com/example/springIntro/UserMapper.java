package com.example.springIntro;

import org.springframework.stereotype.Component;

//@Mapper(componentModel = "spring")
//public interface UserMapper {
//    UserDTO toDto(User user);
//}
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
