package br.com.veterinaryclinic.client;

import br.com.veterinaryclinic.address.AddressResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record ClientResponse(
        Long id,
        String name,

        @JsonProperty("email")
        String emailAddress,

        @JsonProperty("birth_date")
        @JsonFormat(
                shape = JsonFormat.Shape.STRING,
                pattern = "dd-MM-yyyy")
        LocalDate birthDate,
        AddressResponse address
) { }
