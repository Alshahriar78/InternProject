package com.example.springIntro.service;

import com.example.springIntro.model.dto.UserDTO;
import com.example.springIntro.model.entity.User;
import com.example.springIntro.model.mapper.UserMapper;
import com.example.springIntro.repo.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> save(UserDTO dto){
        UserMapper mapper = new UserMapper();// create Object of mapper ;
        User entity = mapper.toEntity(dto);// convert dto to entity;
        userRepository.save(entity); // user saved to a database;
        return ResponseEntity.ok("User saved successfully"); // Response Send to a client;
    }

    public ResponseEntity<UserDTO> seachByID(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(userMapper.toDTO(user.get()));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    public UserDTO updateUser(Long id, UserDTO dto) {
    User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    user.setPhoneNumber(dto.getPhoneNumber());
    User updatedUser = userRepository.save(user);
    return userMapper.toDTO(updatedUser);
    }
}
