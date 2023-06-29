package br.com.veterinaryclinic.entities;

import br.com.veterinaryclinic.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

@Entity
public class Attendant extends User{

    @Id
    private Long id;



    protected Attendant(
            @NotNull(message = "Name cannot be null.") String name,
            @NotNull(message = "Email cannot be null.") String emailAddress,
            @NotNull(message = "Username cannot be null.") String username,
            @NotNull(message = "Password cannot be null.") String password,
            @NonNull Role role) {

        super(name, emailAddress, username, password, role);
    }

    public Attendant() {
        super();
    }
}
