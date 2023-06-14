package br.com.veterinaryclinic.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping(value = "/list")
    public ResponseEntity<List<ClientResponse>> listClient() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.listAllClients());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClientById(@PathVariable Long id) {
        ClientResponse response = this.service.findPatientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
