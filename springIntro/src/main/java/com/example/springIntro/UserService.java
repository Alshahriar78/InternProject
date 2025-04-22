package com.example.springIntro;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;



import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public String userDetailsSave(UserDTO dto){
        UserMapper mapper = new UserMapper();
        User entity = mapper.toEntity(dto);

        // business logic
        userRepository.save(entity);
        return "User save Successful.......";
    }






    public String deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
        return "User delete Successful.......";
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO dto) {
//        UserDTO updated = userRepository.updateUser(id, dto);
//        return ResponseEntity.ok(updated);
//    }
public UserDTO updateUser(Long id, UserDTO dto) {
    // 1. Find user or throw error
    User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

    // 2. Update fields
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    user.setPhoneNumber(dto.getPhoneNumber());

    // 3. Save updated user
    User updatedUser = userRepository.save(user);

    // 4. Return mapped DTO
    return userMapper.toDTO(updatedUser);
}


    public UserDTO userFindById(Long id) {
        return userMapper.toDTO(userRepository.findById(id).get());
    }

    public List<UserDTO> allUser() {
        return  userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
}
