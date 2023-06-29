package br.com.veterinaryclinic.entities;

import br.com.veterinaryclinic.enums.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Client extends User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Client(
            @NotNull(message = "Name cannot be null.") String name,
            @NotNull(message = "Email cannot be null.") String emailAddress,
            @NotNull(message = "Username cannot be null.") String username,
            @NotNull(message = "Password cannot be null.") String password,
            @NonNull Role role,
            @NonNull String phone,
            @NotNull(message = "CPF cannot be null.") String cpf,
            @NonNull LocalDate birthDate,
            @NonNull Address address,
            @NonNull List<Pet> pets) {

        super(name, emailAddress, username, password, role);
        this.phone = phone;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.address = address;
        this.pets = pets;
    }

    public Long getId() {
        return this.id;
    }

    @NonNull
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }

    @NonNull
    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(@NonNull String cpf) {
        this.cpf = cpf;
    }

    @NonNull
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(@NonNull LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @NonNull
    public Address getAddress() {
        return this.address;
    }

    public void setAddress(@NonNull Address address) {
        this.address = address;
    }

    @NonNull
    public List<Pet> getPets() {
        return this.pets;
    }

    public void setPets(@NonNull List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "Client" + "[", "]")
                .add("id=" + this.id)
                .add("name=" + super.name)
                .add("username=" + super.username)
                .add("role=" + super.role)
                .add("birthDate=" + this.birthDate)
                .add("cpf=" + this.cpf)
                .add("emailAddress=" + super.emailAddress)
                .add("address=" + this.address)
                .add("pets=" + this.pets)
                .toString();
    }
}