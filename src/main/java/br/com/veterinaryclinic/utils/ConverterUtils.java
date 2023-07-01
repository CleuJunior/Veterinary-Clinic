package br.com.veterinaryclinic.utils;

import br.com.veterinaryclinic.dtos.ClientRequest;
import br.com.veterinaryclinic.dtos.PetRequest;
import br.com.veterinaryclinic.entities.Address;
import br.com.veterinaryclinic.entities.Client;
import br.com.veterinaryclinic.entities.Pet;

import java.util.List;

public final class ConverterUtils {

    private ConverterUtils() {
    }

    public static Client toClient(ClientRequest client, List<Pet> pets, Address address, String encodedPassword) {
        return new Client(client.name(), client.emailAddress(), client.userName(), encodedPassword, client.role(),
                 client.phone(), client.cpf(), client.birthDate(), address, pets);
    }

    public static Pet toPet(PetRequest petRequest) {
        return new Pet(petRequest.petName(), petRequest.type());
    }
}