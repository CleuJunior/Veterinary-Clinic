package br.com.veterinaryclinic.utils.mapper;

import br.com.veterinaryclinic.client.Client;
import br.com.veterinaryclinic.client.ClientResponse;
import br.com.veterinaryclinic.pet.Pet;
import br.com.veterinaryclinic.pet.PetResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor(access = AccessLevel.NONE)
public class PetMapperUtils {

    public static PetResponse toPetResponse(Pet pet) {
        return new PetResponse(
                pet.getId(),
                pet.getPetName(),
                pet.getType(),
                pet.getBirthDate(),
                AddressMapperUtils.toAddressResponse(pet.getAddress())
        );

    }
}
