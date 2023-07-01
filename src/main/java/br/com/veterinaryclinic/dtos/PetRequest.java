package br.com.veterinaryclinic.dtos;

import br.com.veterinaryclinic.enums.AnimalGroupType;

public record PetRequest(String petName, AnimalGroupType type) {
}
