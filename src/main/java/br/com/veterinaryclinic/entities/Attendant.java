package br.com.veterinaryclinic.entities;

import br.com.veterinaryclinic.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class Attendant extends User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "badge_number", unique = true, nullable = false)
    private Long badgeNumber;

    public Attendant() {
        super();
    }

    public Attendant(@NonNull @NotNull(message = "Name cannot be null.") String name,
                     @NonNull @NotNull(message = "Email cannot be null.") String emailAddress,
                     @NonNull @NotNull(message = "Username cannot be null.") String username,
                     @NonNull @NotNull(message = "Password cannot be null.") String password,
                     @NonNull @NotNull(message = "Role cannot be null.") Role role,
                     @NonNull @NotNull(message = "Badge number cannot be null.") Long badgeNumber) {

        super(name, emailAddress, username, password, role);
        this.badgeNumber = badgeNumber;
    }
}