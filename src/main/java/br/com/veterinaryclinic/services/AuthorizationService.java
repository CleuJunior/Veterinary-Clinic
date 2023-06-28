package br.com.veterinaryclinic.services;

import br.com.veterinaryclinic.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationService implements UserDetailsService {
    private final ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.clientRepository.findByUsername(username);
    }
}
