package br.com.veterinaryclinic.client;

import br.com.veterinaryclinic.pet.Pet;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Embedded
    @NonNull
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PUBLIC)
    private Address address;

    @OneToMany(targetEntity=Pet.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @NonNull
    private List<Pet> pets;

    public String getStreetName() {
        return this.address.getStreetName();
    }

    public Integer getHouseNumber() {
        return this.address.getHouseNumber();
    }

    public String getZipCode() {
        return this.address.getZipcode();
    }
}
