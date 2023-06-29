package br.com.veterinaryclinic.controllers;

import br.com.veterinaryclinic.config.sercutiry.TokenService;
import br.com.veterinaryclinic.dtos.AuthenticationRequest;
import br.com.veterinaryclinic.dtos.RegisterRequest;
import br.com.veterinaryclinic.dtos.TokenResponse;
import br.com.veterinaryclinic.entities.Client;
import br.com.veterinaryclinic.repositories.ClientRepository;
import jakarta.validation.Valid;
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
public class AuthController {
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager, ClientRepository clientRepository,
                          TokenService tokenService) {

        this.authenticationManager = authenticationManager;
        this.clientRepository = clientRepository;
        this.tokenService = tokenService;
    }

    private final ClientRepository clientRepository;
    private final TokenService tokenService;

    @PostMapping(value = "/login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid AuthenticationRequest request) {
        UsernamePasswordAuthenticationToken usernamePassword = new  UsernamePasswordAuthenticationToken(request.login(),
                request.password());

        System.out.println(this.clientRepository.findAll());

        Authentication auth = this.authenticationManager.authenticate(usernamePassword);
        String token = this.tokenService.generateToken((Client) auth.getPrincipal());

        return ResponseEntity.ok(new TokenResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest request) {
        if (this.clientRepository.findByUsername(request.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(request.password());

//        this.clientRepository.save();

        return ResponseEntity.ok().build();
    }
}
