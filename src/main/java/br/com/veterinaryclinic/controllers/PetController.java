package br.com.veterinaryclinic.controllers;

import br.com.veterinaryclinic.dtos.PetRequest;
import br.com.veterinaryclinic.dtos.PetResponse;
import br.com.veterinaryclinic.services.PetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/pet")
public class PetController {
    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<PetResponse>> listClient(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.listAllPets(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetResponse> getPetById(@PathVariable Long id) {
        PetResponse response = this.service.findPetById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<PetResponse> updatePet(@PathVariable Long id, @RequestBody PetRequest request) {
        PetResponse response = this.service.updatePet(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletePetById(@PathVariable Long id) {
        this.service.deletePetById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
