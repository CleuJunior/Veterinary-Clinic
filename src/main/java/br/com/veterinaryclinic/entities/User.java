package br.com.veterinaryclinic.entities;

import br.com.veterinaryclinic.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public abstract class User implements UserDetails {

    @Column(nullable = false)
    @NotBlank(message = "Name cannot be blank.")
    protected String name;

    @Column(name = "email", unique = true, nullable = false)
    @NotBlank(message = "Email cannot be blank.")
    protected String emailAddress;

    @NotBlank(message = "Username cannot be blank.")
    protected String username;

    @NotBlank(message = "Password cannot be blank.")
    protected String password;

    @Enumerated(EnumType.STRING)
    protected Role role;

    protected User() {
    }

    protected User(
            @NotNull(message = "Name cannot be null.")
            @NonNull
            String name,

            @NotNull(message = "Email cannot be null.")
            String emailAddress,

            @NotNull(message = "Username cannot be null.")
            @NonNull
            String username,

            @NotNull(message = "Password cannot be null.")
            @NotNull(message = "Password cannot be null.")
            String password,

            @NonNull
            Role role
    ) {

        this.name = name;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(@NonNull String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(@NonNull Role role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == Role.USER) return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(name, user.name) && Objects.equals(emailAddress, user.emailAddress) &&
                Objects.equals(username, user.username) && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emailAddress, username, password, role);
    }
}