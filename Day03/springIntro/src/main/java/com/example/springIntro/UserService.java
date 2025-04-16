package com.example.springIntro;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public void save(UserDTO dto){
        UserMapper mapper = new UserMapper();
        User entity = mapper.map(dto);

        // business logic
        userRepository.save(entity);
    }
    public ResponseEntity<UserDTO> findById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(userMapper.map(user.get()));
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

    // 3. Save updated user
    User updatedUser = userRepository.save(user);

    // 4. Return mapped DTO
    return userMapper.map(updatedUser);
}

}
