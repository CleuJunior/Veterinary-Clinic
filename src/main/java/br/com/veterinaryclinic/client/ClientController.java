package br.com.veterinaryclinic.client;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<ClientResponse>> listClient(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.service.listAllClients(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClientById(@PathVariable Long id) {
        ClientResponse response = this.service.findPatientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ClientResponse> saveBrand(@RequestBody ClientRequest request) {
        ClientResponse response = this.service.insertNewClient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientResponse> updatePatient(@PathVariable Long id, @RequestBody ClientRequest request) {
        ClientResponse response = this.service.updateClient(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
