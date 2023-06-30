package br.com.veterinaryclinic.repositories;

import br.com.veterinaryclinic.entities.Attendant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendantRepository extends JpaRepository<Attendant, Long> {
    UserDetails findByUsername(String username);
}