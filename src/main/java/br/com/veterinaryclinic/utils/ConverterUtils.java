package br.com.veterinaryclinic.utils;

import br.com.veterinaryclinic.address.Address;
import br.com.veterinaryclinic.client.Client;
import br.com.veterinaryclinic.client.ClientRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class ConverterUtils {

    public static Client toClient(ClientRequest client, Address address) {
        return new Client(client.name(), client.emailAddress(), client.phone(), client.cpf(), client.birthDate(), address);
    }
}
