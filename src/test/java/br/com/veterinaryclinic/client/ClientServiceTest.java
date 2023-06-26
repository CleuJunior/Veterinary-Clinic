package br.com.veterinaryclinic.client;

import br.com.veterinaryclinic.pet.AnimalGroupType;
import br.com.veterinaryclinic.pet.Pet;
import br.com.veterinaryclinic.pet.PetRepository;
import br.com.veterinaryclinic.pet.PetResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private PetRepository petRepository;
    private List<Pet> petListOne ;
    private List<Pet> petLisTwo;
    private Address addressOne;
    private Address addressTwo;
    private Client clientOne;
    private Client clientTwo;

    @BeforeEach
    void setUp() {
        this.petListOne = List.of(new Pet("Max", AnimalGroupType.CANINE));
        this.petLisTwo = List.of(new Pet("Rex", AnimalGroupType.FELINE));
        this.addressOne = new Address("Rua Aduaneira", 190, "8889182");
        this.addressTwo = new Address("Rua Pedro Cachola", 229, "7789182");

        this.clientOne = new Client("Maria", "maria@gmail.com", "999999901","88888888801",
                LocalDate.of(1989, 11, 25), this.addressOne, this.petListOne);
        this.clientTwo = new Client("Alvez", "alvez@gmail.com", "999999902", "88888888802",
                LocalDate.of(1999, 5, 13), this.addressTwo, this.petLisTwo);
    }

    @Test
    void shouldReturnListOfClientWhenCallingListAllClients() {
        Pageable pageable = Pageable.ofSize(10).withPage(0);

        List<Client> clients = Arrays.asList(this.clientOne, this.clientTwo);
        Page<Client> clientPage = new PageImpl<>(clients, pageable, clients.size());

        Mockito.when(this.clientRepository.findAll(pageable)).thenReturn(clientPage);

        Page<ClientResponse> actual = this.clientService.listAllClients(pageable);
        List<ClientResponse> clientResponse = actual.getContent();

        // Assertions size
        Assertions.assertEquals(2, actual.getContent().size());
        // Assertion index 0
        Assertions.assertEquals("Maria", clientResponse.get(0).name());
        Assertions.assertEquals("maria@gmail.com", clientResponse.get(0).emailAddress());
        Assertions.assertEquals("999999901", clientResponse.get(0).phone());
        Assertions.assertEquals(LocalDate.of(1989, 11, 25), clientResponse.get(0).birthDate());
        Assertions.assertEquals(this.addressOne.getStreetName(), clientResponse.get(0).streetName());
        Assertions.assertEquals(this.addressOne.getHouseNumber(), clientResponse.get(0).houseNumber());
        Assertions.assertEquals(this.addressOne.getZipcode(), clientResponse.get(0).zipcode());
        Assertions.assertEquals(this.petListOne.stream().map(PetResponse::new).toList(), clientResponse.get(0).pets());
        // Assertion index 1
        Assertions.assertEquals("Alvez", clientResponse.get(1).name());
        Assertions.assertEquals("alvez@gmail.com", clientResponse.get(1).emailAddress());
        Assertions.assertEquals("999999902", clientResponse.get(1).phone());
        Assertions.assertEquals(LocalDate.of(1999, 5, 13), clientResponse.get(1).birthDate());
        Assertions.assertEquals(this.addressTwo.getStreetName(), clientResponse.get(1).streetName());
        Assertions.assertEquals(this.addressTwo.getHouseNumber(), clientResponse.get(1).houseNumber());
        Assertions.assertEquals(this.addressTwo.getZipcode(), clientResponse.get(1).zipcode());
        Assertions.assertEquals(this.petLisTwo.stream().map(PetResponse::new).toList(), clientResponse.get(1).pets());

        Mockito.verify(this.clientRepository).findAll(pageable);
        Mockito.verifyNoMoreInteractions(this.clientRepository);
    }

    @Test
    void shouldReturnClientWhenCallingFindClientById() {
        Mockito.when(this.clientRepository.findById(1L)).thenReturn(Optional.of(this.clientOne));

        ClientResponse expected = this.clientService.findClientById(1L);
        ClientResponse actual = new ClientResponse(this.clientOne);

        Assertions.assertEquals(expected, actual);

        Mockito.verify(this.clientRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(this.clientRepository);
    }

    @Test
    void shouldDeleteClientByIdWhenCallingDeleteById() {
        Long clientId = 1L;

        Mockito.when(this.clientRepository.findById(clientId)).thenReturn(Optional.of(this.clientOne));
        Mockito.doNothing().when(this.clientRepository).delete(this.clientOne);

        this.clientService.deleteClientById(clientId);

        Mockito.verify(this.clientRepository).findById(clientId);
        Mockito.verify(this.clientRepository).delete(this.clientOne);
        Mockito.verifyNoMoreInteractions(this.clientRepository);
    }
}