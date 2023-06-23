package br.com.veterinaryclinic.client;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "street_name")
    @NonNull
    private String streetName;

    @Column(name = "house_number")
    @NonNull
    private Integer houseNumber;

    @Column(nullable = false)
    @NotBlank(message = "Zipcode cannot be blank.")
    @NotNull(message = "ZipCode cannot be null.")
    @NonNull
    private String zipcode;

}
