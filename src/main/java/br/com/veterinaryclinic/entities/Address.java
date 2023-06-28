package br.com.veterinaryclinic.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

import java.io.Serial;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

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
