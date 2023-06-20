package br.com.veterinaryclinic.utils;

import br.com.veterinaryclinic.client.Address;
import br.com.veterinaryclinic.client.Client;
import br.com.veterinaryclinic.client.ClientRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConverterUtils {

    public static Client toClient(ClientRequest client) {
        return new Client(
                client.name(),
                client.emailAddress(),
                client.phone(),
                client.cpf(),
                client.birthDate(),
                new Address(client.streetName(), client.houseNumber(), client.zipcode())
        );
    }
}
