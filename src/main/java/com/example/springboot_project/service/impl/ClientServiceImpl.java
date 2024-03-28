package com.example.springboot_project.service.impl;

import com.example.springboot_project.DTO.ClientDto;
import com.example.springboot_project.model.Client;
import com.example.springboot_project.repository.ClientRepository;
import com.example.springboot_project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Client newClient = clientRepository.save(client);

        //Convert entity to DTO and return it
        return  mapToDto(newClient);
    }

    @Override
    public List<ClientDto> getAllPost() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(client -> mapToDto(client)).collect(Collectors.toList());
    }

    //convert entity into Dto
    private ClientDto mapToDto(Client client){
        ClientDto clientDto= new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setLastName(client.getLastName());
        clientDto.setPhoneNum(client.getPhoneNumber());
        clientDto.setEmail(client.getEmail());
        return clientDto;
    }
    //Convert Dto to entity
    private Client mapToEntity(ClientDto clientDto){
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setLastName(clientDto.getLastName());
        client.setPhoneNumber(clientDto.getPhoneNum());
        client.setEmail(clientDto.getEmail());
        return client;

    }
}
