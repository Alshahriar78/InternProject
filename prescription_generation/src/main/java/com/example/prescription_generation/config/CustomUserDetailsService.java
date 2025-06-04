package com.example.prescription_generation.config;

import com.example.prescription_generation.model.entity.Muser.MUser;
import com.example.prescription_generation.repository.DoctorRepository;
import com.example.prescription_generation.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {


        Optional<MUser> user = doctorRepository.findByEmail(email)
                .map(doctor -> (MUser) doctor);

        if (user.isEmpty()) {
            user = patientRepository.findByEmail(email)
                    .map(patient -> (MUser) patient);
        }

        MUser foundUser = user.orElseThrow(() -> 
                new UsernameNotFoundException("User not found with email: " + email));

        return new CustomUserDetails(foundUser);
    }
}
