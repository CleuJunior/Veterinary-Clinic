package br.com.veterinaryclinic.config.sercutiry;

import br.com.veterinaryclinic.repositories.ClientRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final ClientRepository clientRepository;
    private static final String HEADER = "Authorization";
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = this.recoverToken(request);

        if (token == null) {
            filterChain.doFilter(request, response);
        }

        String subject =  this.tokenService.validateToken(token);
        UserDetails client = this.clientRepository.findByUsername(subject);
        AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(client, null,
                client.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recoverToken(HttpServletRequest request) {
        String authHeader = request.getHeader(HEADER);
        return (authHeader != null) ? authHeader.replace("Bearer", "") : null;
    }
}