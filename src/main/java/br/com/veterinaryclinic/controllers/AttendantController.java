package br.com.veterinaryclinic.controllers;

import br.com.veterinaryclinic.config.sercutiry.TokenService;
import br.com.veterinaryclinic.dtos.AuthenticationRequest;
import br.com.veterinaryclinic.dtos.RegisterRequest;
import br.com.veterinaryclinic.dtos.TokenResponse;
import br.com.veterinaryclinic.entities.Attendant;
import br.com.veterinaryclinic.entities.Client;
import br.com.veterinaryclinic.repositories.AttendantRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/attendant")
public class AttendantController {
    private final AuthenticationManager authenticationManager;
    private final AttendantRepository attendantRepository;
    private final TokenService tokenService;

    public AttendantController(AuthenticationManager authenticationManager, AttendantRepository attendantRepository,
                          TokenService tokenService) {

        this.authenticationManager = authenticationManager;
        this.attendantRepository = attendantRepository;
        this.tokenService = tokenService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid AuthenticationRequest request) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(request.login(),
                request.password());

        Authentication auth = this.authenticationManager.authenticate(usernamePassword);
        String token = this.tokenService.generateToken((UserDetails) auth.getPrincipal());

        return ResponseEntity.ok(new TokenResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest request) {
        if (this.attendantRepository.findByUsername(request.username()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(request.password());

        Attendant atte = new Attendant(request.name(), request.emailAddress(),
                request.username(), request.password(), request.role(), request.badgeNumber());

        this.attendantRepository.save(atte);

        return ResponseEntity.ok().build();
    }
}