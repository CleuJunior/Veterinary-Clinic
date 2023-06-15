package br.com.veterinaryclinic.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/pet")
@RequiredArgsConstructor
public class PetController {
    private final PetService service;

    @GetMapping(value = "/list")
    public ResponseEntity<List<PetResponse>> listClient() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.listAllPets());
    }


    @GetMapping("/{id}")
    public ResponseEntity<PetResponse> getPetById(@PathVariable Long id) {
        PetResponse response = this.service.findPetById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Pet> saveBrand(@RequestBody Pet request) {
        Pet response = this.service.savePet(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
