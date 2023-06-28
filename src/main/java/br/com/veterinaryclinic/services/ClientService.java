package br.com.veterinaryclinic.services;

import br.com.veterinaryclinic.entities.Client;
import br.com.veterinaryclinic.repositories.ClientRepository;
import br.com.veterinaryclinic.dtos.ClientRequest;
import br.com.veterinaryclinic.dtos.ClientResponse;
import br.com.veterinaryclinic.entities.Address;
import br.com.veterinaryclinic.exceptions.ClientNotFoundException;
import br.com.veterinaryclinic.exceptions.PetNotFoundException;
import br.com.veterinaryclinic.entities.Pet;
import br.com.veterinaryclinic.repositories.PetRepository;
import br.com.veterinaryclinic.utils.ConverterUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final PetRepository petRepository;
    private final AuthenticationManager authenticationManager;


    public Page<ClientResponse> listAllClients(Pageable pageable) {
        return this.clientRepository.findAll(pageable).map(ClientResponse::new);
    }

    public ClientResponse findClientById(Long id) {
        Client client = this.clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
        return new ClientResponse(client);
    }

    public ClientResponse insertNewClient(ClientRequest request) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(request.password());

        List<Pet> pets = request.pets()
                .stream()
                .map(ConverterUtils::toPet)
                .toList();

        pets = this.petRepository.saveAll(pets);
        Client client = ConverterUtils.toClient(request, pets, request.address(), encryptedPassword);
        client = this.clientRepository.save(client);

        this.petRepository.saveAll(pets);
        return new ClientResponse(client);
    }

    public ClientResponse updateClient(Long id, ClientRequest request) {
        Client client = this.clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        List<Pet> pets = new ArrayList<>();

        for (int i = 0; i < client.getPets().size(); i++) {
            Long petId = client.getPets().get(i).getId();
            Pet petUpdate = this.petRepository.findById(petId)
                    .orElseThrow(() -> new PetNotFoundException(petId));

            petUpdate.setPetName(request.pets().get(i).petName());
            petUpdate.setType(request.pets().get(i).type());
            pets.add(this.petRepository.save(petUpdate));
        }

        client.setName(request.name());
        client.setEmailAddress(request.emailAddress());
        client.setPhone(request.phone());
        client.setCpf(request.cpf());
        client.setBirthDate(request.birthDate());
//        client.setAddress(new Address(request.streetName(), request.houseNumber(), request.zipcode()));
        client.setPets(pets);

        this.clientRepository.save(client);

        return new ClientResponse(client);
    }

    public void deleteClientById(Long id) {
        Client client = this.clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        this.clientRepository.delete(client);
    }
}