package br.com.veterinaryclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Client implements Serializable {

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

}
