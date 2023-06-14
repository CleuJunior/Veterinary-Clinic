package br.com.veterinaryclinic.address;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddressResponse(

        @JsonProperty("street_name")
        String name,

        @JsonProperty("house_number")
        Integer houseNumber,
        String zipcode
) { }
