package br.com.veterinaryclinic.services;

import br.com.veterinaryclinic.entities.Pet;
import br.com.veterinaryclinic.exceptions.PetNotFoundException;
import br.com.veterinaryclinic.repositories.PetRepository;
import br.com.veterinaryclinic.dtos.PetRequest;
import br.com.veterinaryclinic.dtos.PetResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public Page<PetResponse> listAllPets(Pageable pageable) {
        return this.petRepository.findAll(pageable).map(PetResponse::new);
    }

    public PetResponse findPetById(Long id) {
        Pet pet = this.petRepository.findById(id).orElseThrow(() -> new PetNotFoundException(id));
        return new PetResponse(pet);
    }

    public PetResponse updatePet(Long id, PetRequest petRequest) {
        Pet pet = this.petRepository.findById(id).orElseThrow(() -> new PetNotFoundException(id));
        pet.setPetName(petRequest.petName());
        pet.setType(petRequest.type());
        return new PetResponse(pet);
    }

    public void deletePetById(Long id) {
        Pet pet = this.petRepository.findById(id).orElseThrow(() -> new PetNotFoundException(id));
        this.petRepository.delete(pet);
    }
}