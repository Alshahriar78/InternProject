package org.healthcare.AppointmentBooking.service;

import lombok.AllArgsConstructor;
import org.healthcare.AppointmentBooking.model.dto.UsersDTO;
import org.healthcare.AppointmentBooking.model.entity.Users;
import org.healthcare.AppointmentBooking.model.mapper.UsersMapper;
import org.healthcare.AppointmentBooking.repository.UsersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;
    private final PasswordEncoder passwordEncoder;



    public ResponseEntity<String> register(UsersDTO dto){
        // create Object of mapper ;
        Users entity = usersMapper.toEntity(dto);// convert dto to entity;
        usersRepository.save(entity); // user saved to a database;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return ResponseEntity.ok("User saved successfully"); // Response Send to a client;
    }
    public UsersDTO showDashboardByUsername(String username) {
        Users user = usersRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return usersMapper.toDTO(user);
    }


    public Users updateUserProfile(Long id, UsersDTO usersDTO) {
        Users users = usersRepository.findById(id).orElseThrow();
        users.setFullName(usersDTO.getFullName());
        users.setMobileNumber(usersDTO.getMobileNumber());
        users.setEmail(usersDTO.getEmail());
        users.setGender(usersDTO.getGender());
        users.setDateOfBirth(usersDTO.getDateOfBirth());
        // Encrypt password before saving
        if (usersDTO.getPassword() != null && !usersDTO.getPassword().isEmpty()) {
            users.setPassword(passwordEncoder.encode(usersDTO.getPassword()));
        }
        return usersRepository.save(users);
    }


    public Users getUserByUsername(String usersName) {
        return usersRepository.findByFullName(usersName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
