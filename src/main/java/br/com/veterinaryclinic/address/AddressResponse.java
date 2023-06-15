package br.com.veterinaryclinic.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"zipcode"})
public record AddressResponse(@JsonProperty("street_name") String name,
                              @JsonProperty("house_number") Integer houseNumber, String zipcode){

        public AddressResponse(Address address) {
                this(address.getStreetName(), address.getHouseNumber(), address.getZipcode());
        }
}
