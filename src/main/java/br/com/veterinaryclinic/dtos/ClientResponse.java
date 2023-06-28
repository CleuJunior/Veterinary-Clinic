package br.com.veterinaryclinic.dtos;

import br.com.veterinaryclinic.entities.Client;
import br.com.veterinaryclinic.entities.Address;
import br.com.veterinaryclinic.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
import java.util.List;

@JsonPropertyOrder({"id", "name", "email", "phone"})
public record ClientResponse(Long id, String name, @JsonProperty("email") String emailAddress, String phone,
                             @JsonProperty("birth_date") @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy") LocalDate birthDate,
                             Address address, List<PetResponse> pets, String username, String password, Role role) {

        public ClientResponse(Client client) {
                this(client.getId(), client.getName(), client.getEmailAddress(), client.getPhone(), client.getBirthDate(),
                        client.getAddress(), client.getPets().stream().map(PetResponse::new).toList(), client.getUsername(),
                        client.getPassword(), client.getRole());
        }
}
