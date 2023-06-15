package br.com.veterinaryclinic.pet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnimalGroupType {

    CANINE("Canino"),
    FELINE("Felino"),
    EQUINE("Equino");

    private final String animalType;
}
