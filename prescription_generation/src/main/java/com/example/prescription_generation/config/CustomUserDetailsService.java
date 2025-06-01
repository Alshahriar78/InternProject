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

        // First try to find a doctor with the given email
        Optional<MUser> user = doctorRepository.findByEmail(email)
                .map(doctor -> (MUser) doctor);

        // If not found, try to find a patient with the given email
        if (user.isEmpty()) {
            user = patientRepository.findByEmail(email)
                    .map(patient -> (MUser) patient);
        }

        // If still not found, throw an exception
        MUser foundUser = user.orElseThrow(() -> 
                new UsernameNotFoundException("User not found with email: " + email));

        return new CustomUserDetails(foundUser);
    }
}
