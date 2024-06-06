package com.example.buensaboruno.services;

import com.example.buensaboruno.domain.entities.Cliente;

import java.util.List;

public  interface ClienteService {
    Cliente save(Cliente cliente);
    List<Cliente> getTodas();
}
