package br.com.veterinaryclinic.enums;

public enum AnimalGroupType {
    CANINE("Canino"),
    FELINE("Felino"),
    EQUINE("Equino");

    private final String animalType;

    AnimalGroupType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalType() {
        return this.animalType;
    }
}