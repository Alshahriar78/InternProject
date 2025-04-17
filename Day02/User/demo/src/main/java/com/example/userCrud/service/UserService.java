package com.example.usercrud.service;

import com.example.usercrud.dto.UserRequestDTO;
import com.example.usercrud.dto.UserResponseDTO;
import com.example.usercrud.entity.User;
import com.example.usercrud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepo.findAll().stream()
                .map(user -> new UserResponseDTO(user.getId(), user.getName()))
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(Long id) {
        return userRepo.findById(id)
                .map(user -> new UserResponseDTO(user.getId(), user.getName()))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        User saved = userRepo.save(user);
        return new UserResponseDTO(saved.getId(), saved.getName());
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        return userRepo.findById(id)
                .map(user -> {
                    user.setName(dto.getName());
                    User updated = userRepo.save(user);
                    return new UserResponseDTO(updated.getId(), updated.getName());
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
