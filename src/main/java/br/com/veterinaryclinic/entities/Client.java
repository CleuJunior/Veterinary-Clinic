package br.com.veterinaryclinic.entities;

import br.com.veterinaryclinic.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Client implements Serializable, UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name cannot be blank.")
    @NotNull(message = "Name cannot be null.")
    @NonNull
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    @NotBlank(message = "Email cannot be blank.")
    @NotNull(message = "Email cannot be null.")
    @NonNull
    private String emailAddress;

    @Column(unique = true, nullable = false)
    @NonNull
    private String phone;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "CPF cannot be blank.")
    @NotNull(message = "CPF cannot be null.")
    @NonNull
    private String cpf;

    @Column(name = "birth_date")
    @NonNull
    private LocalDate birthDate;

    @OneToOne
    @JoinColumn(name = "address_id")
    @NonNull
    private Address address;

    @OneToMany(targetEntity= Pet.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @NonNull
    private List<Pet> pets;

    @NonNull
    @NotBlank(message = "Username cannot be blank.")
    @NotNull(message = "Username cannot be null.")
    private String username;

    @NonNull
    @NotBlank(message = "Password cannot be blank.")
    @NotNull(message = "Password cannot be null.")
    private String password;

    @Enumerated(EnumType.STRING)
    @NonNull
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == Role.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }

        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}