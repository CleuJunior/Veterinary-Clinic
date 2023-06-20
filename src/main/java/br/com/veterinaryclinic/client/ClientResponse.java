package br.com.veterinaryclinic.client;

import br.com.veterinaryclinic.pet.PetResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
import java.util.List;

@JsonPropertyOrder({"id", "name", "email", "phone"})
public record ClientResponse(Long id, String name, @JsonProperty("email") String emailAddress, String phone,
        @JsonProperty("birth_date") @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy") LocalDate birthDate,
        @JsonProperty("street_name") String streetName, @JsonProperty("house_number") Integer houseNumber, String zipcode,
        List<PetResponse> pets) {

        public ClientResponse(Client client) {
                this(
                        client.getId(),
                        client.getName(),
                        client.getEmailAddress(),
                        client.getPhone(),
                        client.getBirthDate(),
                        client.getStreetName(),
                        client.getHouseNumber(),
                        client.getZipCode(),
                        client.getPets().stream().map(PetResponse::new).toList()
                );
        }
}
