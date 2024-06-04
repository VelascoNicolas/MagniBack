package com.example.buensaboruno.services;

import com.example.buensaboruno.domain.entities.UsuarioCliente;

import java.util.List;

public interface UsuarioClienteService {
    public boolean existeUsuario(String usuario);
    public UsuarioCliente save(UsuarioCliente usuario);
    public boolean passwordCheck(UsuarioCliente usuario);
    public UsuarioCliente update(UsuarioCliente usuario, String userName);
}
