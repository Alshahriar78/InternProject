package org.healthcare.AppointmentBooking.service;

import lombok.AllArgsConstructor;
import org.healthcare.AppointmentBooking.model.dto.UsersDTO;
import org.healthcare.AppointmentBooking.model.entity.Users;
import org.healthcare.AppointmentBooking.model.mapper.UsersMapper;
import org.healthcare.AppointmentBooking.repository.UsersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;


    public ResponseEntity<String> register(UsersDTO dto){
        UsersMapper mapper = new UsersMapper();// create Object of mapper ;
        Users entity = mapper.toEntity(dto);// convert dto to entity;
        usersRepository.save(entity); // user saved to a database;
        return ResponseEntity.ok("User saved successfully"); // Response Send to a client;
    }

}
