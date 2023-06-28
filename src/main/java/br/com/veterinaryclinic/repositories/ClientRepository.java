package br.com.veterinaryclinic.repositories;

import br.com.veterinaryclinic.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    UserDetails findByUsername(String login);
}