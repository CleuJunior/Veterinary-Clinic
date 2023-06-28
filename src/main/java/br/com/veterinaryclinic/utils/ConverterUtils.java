package br.com.veterinaryclinic.utils;

import br.com.veterinaryclinic.entities.Address;
import br.com.veterinaryclinic.entities.Client;
import br.com.veterinaryclinic.dtos.ClientRequest;
import br.com.veterinaryclinic.entities.Pet;
import br.com.veterinaryclinic.dtos.PetRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConverterUtils {

    public static Client toClient(ClientRequest client, List<Pet> pets, Address address, String encodedPassword) {
        return new Client(client.name(), client.emailAddress(), client.phone(), client.cpf(), client.birthDate(),
                address, pets, client.userName(), encodedPassword, client.role());
    }

    public static Pet toPet(PetRequest petRequest) {
        return new Pet(petRequest.petName(), petRequest.type());
    }
}
