package br.com.veterinaryclinic.dtos;

import br.com.veterinaryclinic.entities.Address;
import br.com.veterinaryclinic.entities.Pet;
import br.com.veterinaryclinic.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record ClientRequest(
        @NotBlank(message = "Name cannot be blank.")
        @NotNull(message = "Name cannot be null.")
        String name,

        @NotBlank(message = "Email cannot be blank.")
        @NotNull(message = "Email cannot be null.")
        @Email
        @JsonProperty("email")
        String emailAddress,

        @NotBlank(message = "Phone cannot be blank.")
        @NotNull(message = "Phone cannot be null.")
        String phone,

        @NotBlank(message = "CPF cannot be blank.")
        @NotNull(message = "CPF cannot be null.")
        String cpf,

        @JsonProperty("birth_date")
        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
        LocalDate birthDate,

        @NotBlank(message = "Address cannot be blank.")
        @NotNull(message = "Address cannot be null.")
        Address address,

        @NotBlank(message = "Pets cannot be blank.")
        @NotNull(message = "Pets cannot be null.")
        List<PetRequest> pets,

        @NotBlank(message = "Username cannot be blank.")
        @NotNull(message = "Username cannot be null.")
        String userName,

        @NotBlank(message = "Password cannot be blank.")
        @NotNull(message = "Password cannot be null.")
        String password,

        @NotBlank(message = "Role cannot be blank.")
        @NotNull(message = "Role1 cannot be null.")
        Role role
) {
}