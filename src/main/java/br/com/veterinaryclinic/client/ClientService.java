package br.com.veterinaryclinic.client;

import br.com.veterinaryclinic.address.AddressRepository;
import br.com.veterinaryclinic.utils.mapper.ClientMapperUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    public List<ClientResponse> listAllClients() {
        return this.clientRepository.findAll().stream()
                .map(ClientMapperUtils::toClientResponse)
                .toList();
    }

    public ClientResponse findPatientById(Long id) {
        Client client = this.clientRepository.findById(id).orElse(null);
        assert client != null;
        return ClientMapperUtils.toClientResponse(client);
    }
}
