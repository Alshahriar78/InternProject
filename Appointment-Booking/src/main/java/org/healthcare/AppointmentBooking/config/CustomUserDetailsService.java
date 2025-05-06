package org.healthcare.AppointmentBooking.config;



import lombok.RequiredArgsConstructor;
import org.healthcare.AppointmentBooking.model.entity.Users;
import org.healthcare.AppointmentBooking.repository.UsersRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Users users = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(users);
    }
}
