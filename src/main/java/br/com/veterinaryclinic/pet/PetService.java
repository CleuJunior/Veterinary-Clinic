package br.com.veterinaryclinic.pet;

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
        Pet pet = this.petRepository.findById(id).orElse(null);
        assert pet != null;
        return new PetResponse(pet);
    }

    public Pet savePet(Pet pet) {
        return this.petRepository.save(pet);
    }
}
