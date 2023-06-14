package br.com.veterinaryclinic.pet;

import br.com.veterinaryclinic.client.Client;
import br.com.veterinaryclinic.client.ClientResponse;
import br.com.veterinaryclinic.utils.mapper.ClientMapperUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public List<ClientResponse> listAllPets() {

        return this.petRepository.findAll().stream()
                .map(ClientMapperUtils::toClientResponse)
                .toList();
    }

    public ClientResponse findPetById(Long id) {
        Client client = this.petRepository.findById(id).orElse(null);
        assert client != null;
        return ClientMapperUtils.toClientResponse(client);
    }
}
