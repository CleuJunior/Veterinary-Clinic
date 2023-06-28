package br.com.veterinaryclinic.controllers;

import br.com.veterinaryclinic.dtos.AuthenticationRequest;
import br.com.veterinaryclinic.dtos.RegisterRequest;
import br.com.veterinaryclinic.repositories.ClientRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final ClientRepository clientRepository;

    @PostMapping(value = "/login")
    public ResponseEntity<Void> login(@RequestBody @Valid AuthenticationRequest request) {
        UsernamePasswordAuthenticationToken usernamePassword = new  UsernamePasswordAuthenticationToken(request.login(), request.password());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest request) {
        if (this.clientRepository.findByUsername(request.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(request.password());

        return ResponseEntity.ok().build();
    }
}
