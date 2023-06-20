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
        List<Pet> pets = this.petRepository.saveAll(request.pets());
        Client client = ConverterUtils.toClient(request);
        client.setPets(pets);
        client = this.clientRepository.save(client);
//
//        for (Pet pet : pets) {
//            pet.setOwnerName(client);
//        }

        this.petRepository.saveAll(pets);
        return new ClientResponse(client);
    }
//
//    public ClientResponse updateClient(Long id, ClientRequest request) {
//        Client client = this.clientRepository.findById(id).orElse(null);
//        assert client != null;
//
//        client.setName(request.name());
//        client.setEmailAddress(request.emailAddress());
//        client.setPhone(request.phone());
//        client.setCpf(request.cpf());
//        client.setBirthDate(request.birthDate());
//
////        if (!client.getPets().equals(request)) {
////
////        }
//
//        return new ClientResponse(13l, "Teste", "meuemailsdeteste@gmail.com", "999999999999", LocalDate.now(),
//                new AddressResponse("Meu nome", 1234, "88891-00923"),
//                List.of(new PetResponse((Pet) request.pets())));
//    }

}
