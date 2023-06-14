package br.com.veterinaryclinic.utils.mapper;

import br.com.veterinaryclinic.address.Address;
import br.com.veterinaryclinic.address.AddressResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class AddressMapperUtils {

    public static AddressResponse toAddressResponse(Address address) {
        return new AddressResponse(
                address.getStreetName(),
                address.getHouseNumber(),
                address.getZipcode()
        );
    }

}
