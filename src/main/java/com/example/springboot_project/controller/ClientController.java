package com.example.springboot_project.controller;

import com.example.springboot_project.DTO.ClientDto;
import com.example.springboot_project.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto){
        return new ResponseEntity<>(clientService.createClient(clientDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ClientDto> getAllClients(){
        return clientService.getAllClients();
    }
    @GetMapping("/{id}")
    //map variables from url to method parameters in the controller
    public ClientDto getClientById(@PathVariable (name = "id") long id){
        return ResponseEntity.ok(clientService.getClientById(id)).getBody();
    }
    @PutMapping("/update/{id}")
    public ClientDto updateClient(@RequestBody ClientDto clientDto, @PathVariable (name = "id") long id){
       ClientDto clientResponse = clientService.updateClient(clientDto, id);
       return new ResponseEntity<>(clientResponse, HttpStatus.OK).getBody();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable (name = "id") long id){
        clientService.deleteById(id);
        return new ResponseEntity<>("Client deleted successfully", HttpStatus.OK);
    }
}
