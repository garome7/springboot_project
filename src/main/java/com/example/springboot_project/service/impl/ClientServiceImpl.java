package com.example.springboot_project.service.impl;

import com.example.springboot_project.DTO.ClientDto;
import com.example.springboot_project.model.Client;
import com.example.springboot_project.repository.ClientRepository;
import com.example.springboot_project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;


    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        //convert DTO to entity
        Client client = mapToEntity(clientDto);
        System.out.println("CLIENTEEEEEE NUMMMMMMM"+client.getClientNum());
        System.out.println("CLIENTEEEEEE NUMMMMMMM DTO"+clientDto.getClientNum());
        Client newClient = clientRepository.save(client);
        return  mapToDto(newClient);


        //Convert entity to DTO and return it

    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(client -> mapToDto(client)).collect(Collectors.toList());
    }
    @Override
    public ClientDto getClientById(long id){
        Client client = clientRepository.findById(id).orElseThrow(() -> new NoSuchElementException("El cliente con id: "+id+" no existe"));
        return mapToDto(client);
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto, long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new NoSuchElementException("El cliente con id: "+id+" no existe"));
        client.setName(clientDto.getName());
        client.setLastName(clientDto.getLastName());
        client.setPhoneNumber(clientDto.getPhoneNum());
        client.setEmail(clientDto.getEmail());
        Client updatedClient = clientRepository.save(client);
        return mapToDto(updatedClient);

    }

    //convert entity into Dto
    private ClientDto mapToDto(Client client){
        ClientDto clientDto= new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setLastName(client.getLastName());
        clientDto.setPhoneNum(client.getPhoneNumber());
        clientDto.setEmail(client.getEmail());
        clientDto.setClientNum((client.getClientNum()));
        return clientDto;
    }
    //Convert Dto to entity
    private Client mapToEntity(ClientDto clientDto){
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setLastName(clientDto.getLastName());
        client.setPhoneNumber(clientDto.getPhoneNum());
        client.setEmail(clientDto.getEmail());
        client.setClientNum(clientDto.getClientNum());
        return client;

    }
}
