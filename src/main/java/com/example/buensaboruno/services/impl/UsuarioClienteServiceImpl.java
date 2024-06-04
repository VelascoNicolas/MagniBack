package com.example.buensaboruno.services.impl;

import com.example.buensaboruno.domain.entities.UsuarioCliente;
import com.example.buensaboruno.repositories.UsuarioClienteRepository;
import com.example.buensaboruno.services.UsuarioClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioClienteServiceImpl implements UsuarioClienteService {

    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    @Override
    public List<UsuarioCliente> getTodos() {
        return usuarioClienteRepository.findAll();
    }

    @Override
    public boolean existeUsuario(String usuario) {
        return usuarioClienteRepository.existeUsuario(usuario);
    }

    @Override
    public UsuarioCliente save(UsuarioCliente usuario) {
        return usuarioClienteRepository.save(usuario);
    }
}
