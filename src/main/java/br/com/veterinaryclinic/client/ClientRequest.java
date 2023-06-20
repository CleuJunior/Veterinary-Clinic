package br.com.veterinaryclinic.client;

import br.com.veterinaryclinic.pet.Pet;
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

        @JsonProperty("street_name")
        @NotBlank(message = "Street cannot be blank.")
        @NotNull(message = "Street cannot be null.")
        String streetName,

        @JsonProperty("house_number")
        @NotBlank(message = "House number cannot be blank.")
        @NotNull(message = "House number cannot be null.")
        Integer houseNumber,

        @JsonProperty("zipcode")
        @NotBlank(message = "Zipcode number cannot be blank.")
        @NotNull(message = "Zipcode number cannot be null.")
        String zipcode,

        @NotBlank(message = "Pets cannot be blank.")
        @NotNull(message = "Pets cannot be null.")
        List<Pet> pets
) {
}
