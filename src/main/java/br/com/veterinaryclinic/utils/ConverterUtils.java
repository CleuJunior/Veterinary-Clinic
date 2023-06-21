package br.com.veterinaryclinic.utils;

import br.com.veterinaryclinic.client.Address;
import br.com.veterinaryclinic.client.Client;
import br.com.veterinaryclinic.client.ClientRequest;
import br.com.veterinaryclinic.pet.Pet;
import br.com.veterinaryclinic.pet.PetRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConverterUtils {

    public static Client toClient(ClientRequest client, List<Pet> pets) {
        return new Client(
                client.name(),
                client.emailAddress(),
                client.phone(),
                client.cpf(),
                client.birthDate(),
                new Address(client.streetName(), client.houseNumber(), client.zipcode()),
                pets
        );
    }

    public static Pet toPet(PetRequest petRequest) {
        return new Pet(petRequest.petName(), petRequest.type());
    }
}
