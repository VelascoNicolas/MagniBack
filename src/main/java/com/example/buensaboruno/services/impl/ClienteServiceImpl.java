package com.example.buensaboruno.services.impl;

import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.repositories.ClienteRepository;
import com.example.buensaboruno.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getTodas() {
        return clienteRepository.findAll();
    }
}
