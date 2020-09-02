package ru.pflb.student.emulator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pflb.student.emulator.model.dto.ClientDto;
import ru.pflb.student.emulator.service.ClientService;

@RestController
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable long id) {
        ClientDto client = clientService.getClient(id);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/client/{id}")
    public ResponseEntity updateClient(@PathVariable long id, @RequestBody ClientDto client) {
        ClientDto updatedClient = clientService.updateClient(id, client);
        return ResponseEntity.ok(updatedClient);
    }

    @PostMapping("/client")
    public ResponseEntity addClient(@RequestBody ClientDto client) {
        boolean creationSucceed = clientService.addClient(client);
        ResponseEntity response = new ResponseEntity(HttpStatus.CREATED);
        return response;
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity deleteClient(@PathVariable long id) {
        boolean deletionSucceed = clientService.deleteClient(id);
        if (!deletionSucceed) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
