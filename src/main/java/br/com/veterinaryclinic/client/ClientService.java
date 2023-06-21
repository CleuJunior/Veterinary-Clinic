package br.com.veterinaryclinic.client;

import br.com.veterinaryclinic.pet.Pet;
import br.com.veterinaryclinic.pet.PetRepository;
import br.com.veterinaryclinic.pet.PetResponse;
import br.com.veterinaryclinic.utils.ConverterUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final PetRepository petRepository;

    public Page<ClientResponse> listAllClients(Pageable pageable) {
        return this.clientRepository.findAll(pageable).map(ClientResponse::new);
    }

    public ClientResponse findPatientById(Long id) {
        Client client = this.clientRepository.findById(id).orElse(null);
        assert client != null;
        return new ClientResponse(client);
    }

    public ClientResponse insertNewClient(ClientRequest request) {
        List<Pet> pets = request.pets()
                .stream()
                .map(ConverterUtils::toPet)
                .toList();

        pets = this.petRepository.saveAll(pets);
        Client client = ConverterUtils.toClient(request, pets);
        client = this.clientRepository.save(client);

        this.petRepository.saveAll(pets);
        return new ClientResponse(client);
    }

    public ClientResponse updateClient(Long id, ClientRequest request) {
        Client client = this.clientRepository.findById(id).orElse(null);
        assert client != null;

        List<Pet> pets = new ArrayList<>();

        for (int i = 0; i < client.getPets().size(); i++) {
            Pet petUpdate = this.petRepository.findById(client.getPets().get(i).getId()).orElse(null);
            assert petUpdate != null;

            petUpdate.setPetName(request.pets().get(i).petName());
            petUpdate.setType(request.pets().get(i).type());
            pets.add(this.petRepository.save(petUpdate));
        }

        client.setName(request.name());
        client.setEmailAddress(request.emailAddress());
        client.setPhone(request.phone());
        client.setCpf(request.cpf());
        client.setBirthDate(request.birthDate());
        client.setAddress(new Address(request.streetName(), request.houseNumber(), request.zipcode()));
        client.setPets(pets);

        this.clientRepository.save(client);

        return new ClientResponse(client);
    }

}
