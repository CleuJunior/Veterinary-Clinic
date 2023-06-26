package br.com.veterinaryclinic.pet;

import br.com.veterinaryclinic.exceptions.PetNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @InjectMocks
    private PetService service;
    @Mock
    private PetRepository repository;

    @Test
    void shouldReturnListOfPetsWhenCallingListAllPets() {
        Pageable pageable = Pageable.ofSize(10).withPage(0);

        List<Pet> pets = Arrays.asList(
                new Pet("Max", AnimalGroupType.CANINE),
                new Pet("Oliver", AnimalGroupType.FELINE),
                new Pet("Bella", AnimalGroupType.EQUINE)
        );

        Page<Pet> petPage = new PageImpl<>(pets, pageable, pets.size());

        Mockito.when(this.repository.findAll(pageable)).thenReturn(petPage);

        Page<PetResponse> actual = this.service.listAllPets(pageable);
        List<PetResponse> petResponses = actual.getContent();

        // Assertions
        Assertions.assertEquals(3, actual.getContent().size());
        Assertions.assertEquals("Max", petResponses.get(0).name());
        Assertions.assertEquals(AnimalGroupType.CANINE.getAnimalType(), petResponses.get(0).type());
        Assertions.assertEquals("Oliver", petResponses.get(1).name());
        Assertions.assertEquals(AnimalGroupType.FELINE.getAnimalType(), petResponses.get(1).type());
        Assertions.assertEquals("Bella", petResponses.get(2).name());
        Assertions.assertEquals(AnimalGroupType.EQUINE.getAnimalType(), petResponses.get(2).type());

        Mockito.verify(this.repository).findAll(pageable);
        Mockito.verifyNoMoreInteractions(this.repository);
    }

    @Test
    void shouldReturnPetWhenCallingFindPetById() {
        Pet pet = new Pet("Patty", AnimalGroupType.FELINE);
        Mockito.when(this.repository.findById(1L)).thenReturn(Optional.of(pet));
        PetResponse expected = this.service.findPetById(1L);

        PetResponse actual = new PetResponse(pet);
        Assertions.assertEquals(expected, actual);

        Mockito.verify(this.repository).findById(1L);
        Mockito.verifyNoMoreInteractions(this.repository);
    }

    @Test
    void shouldDeletePetByIdWhenCallingDeleteById() {
        Long petId = 1L;
        Pet pet = new Pet("Max", AnimalGroupType.CANINE);

        Mockito.when(this.repository.findById(petId)).thenReturn(Optional.of(pet));
        Mockito.doNothing().when(this.repository).delete(pet);

        this.service.deletePetById(petId);

        Mockito.verify(this.repository).findById(petId);
        Mockito.verify(this.repository).delete(pet);
        Mockito.verifyNoMoreInteractions(this.repository);
    }

    @Test
    void shouldThrowPetNotFoundExceptionWhenPetNotFound() {
        Long petId = 1L;
        Mockito.when(this.repository.findById(petId)).thenReturn(Optional.empty());
        Assertions.assertThrows(PetNotFoundException.class, () -> this.service.findPetById(petId));
    }
}