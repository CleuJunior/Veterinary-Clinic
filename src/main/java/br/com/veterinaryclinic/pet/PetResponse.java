package br.com.veterinaryclinic.pet;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "type"})
public record PetResponse(Long id, String name, String type) {
    public PetResponse(Pet pet) {
        this(pet.getId(), pet.getPetName(), pet.getType().getAnimalType());
    }
}
