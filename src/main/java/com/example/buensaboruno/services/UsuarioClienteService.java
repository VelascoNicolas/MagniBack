package com.example.buensaboruno.services;

import com.example.buensaboruno.domain.entities.UsuarioCliente;

import java.util.List;

public interface UsuarioClienteService {
    public List<UsuarioCliente> getTodos();
    public boolean existeUsuario(String usuario);
    public UsuarioCliente save(UsuarioCliente usuario);
}
