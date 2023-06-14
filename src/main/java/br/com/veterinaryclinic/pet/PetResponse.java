package br.com.veterinaryclinic.pet;

import br.com.veterinaryclinic.address.AddressResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

//@JsonPropertyOrder({"id", "name", "email", "age"})
public record PetResponse(
        Long id,
        String name,
        String type

) { }
