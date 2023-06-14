package br.com.veterinaryclinic.utils.mapper;

import br.com.veterinaryclinic.client.Client;
import br.com.veterinaryclinic.client.ClientResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class ClientMapperUtils {

    public static ClientResponse toClientResponse(Client client) {
        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getEmailAddress(),
                client.getBirthDate(),
                AddressMapperUtils.toAddressResponse(client.getAddress())
        );

    }
}
