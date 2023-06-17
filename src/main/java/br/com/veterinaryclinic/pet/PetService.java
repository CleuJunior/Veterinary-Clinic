package br.com.veterinaryclinic.pet;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public List<PetResponse> listAllPets() {
        return this.petRepository.findAll().stream()
                .map(PetResponse::new)
                .toList();
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
