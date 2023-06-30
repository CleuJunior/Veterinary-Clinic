package br.com.veterinaryclinic.services;

import br.com.veterinaryclinic.repositories.AttendantRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {
    private final AttendantRepository attendantRepository;

    public AuthorizationService(AttendantRepository attendantRepository) {
        this.attendantRepository = attendantRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.attendantRepository.findByUsername(username);
    }
}
