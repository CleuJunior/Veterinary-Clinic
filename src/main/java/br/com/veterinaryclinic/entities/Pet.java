package br.com.veterinaryclinic.entities;

import br.com.veterinaryclinic.enums.AnimalGroupType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Pet implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String petName;

    @Enumerated(EnumType.STRING)
    private AnimalGroupType type;

    public Pet() {
    }

    public Pet(Long id, @NonNull String petName, @NonNull AnimalGroupType type) {
        this.id = id;
        this.petName = petName;
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public String getPetName() {
        return this.petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public AnimalGroupType getType() {
        return this.type;
    }

    public void setType(AnimalGroupType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet pet)) return false;
        return Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "Pet" + "[", "]")
                .add("id=" + this.id)
                .add("petName=" + this.petName)
                .add("type=" + this.type)
                .toString();
    }
}
