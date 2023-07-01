package br.com.veterinaryclinic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street_name")
    @NotBlank(message = "Street name cannot be blank.")
    private String streetName;

    @Column(name = "house_number")
    private Integer houseNumber;

    @Column(nullable = false)
    private String zipcode;

    public Address() {
    }

    public Address(
            @NonNull String streetName,
            @NonNull Integer houseNumber,
            @NonNull String zipcode) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
    }

    public Long getId() {
        return this.id;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getHouseNumber() {
        return this.houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}