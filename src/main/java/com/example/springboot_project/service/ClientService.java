package com.example.springboot_project.service;

import com.example.springboot_project.DTO.ClientDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {
    ClientDto createClient(ClientDto clientDto);

    public List<ClientDto> getAllPost();
}