package br.com.veterinaryclinic.pet;

import br.com.veterinaryclinic.exceptions.PetNotFoundException;
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

    public void deletePet(Long id) {
        Pet pet = this.petRepository.findById(id).orElseThrow(() -> new PetNotFoundException(id));
        this.petRepository.delete(pet);
    }
}