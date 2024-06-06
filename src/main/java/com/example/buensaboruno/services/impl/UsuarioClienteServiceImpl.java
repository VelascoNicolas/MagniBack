package com.example.buensaboruno.services.impl;

import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.domain.entities.UsuarioCliente;
import com.example.buensaboruno.repositories.ClienteRepository;
import com.example.buensaboruno.repositories.UsuarioClienteRepository;
import com.example.buensaboruno.services.UsuarioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioClienteServiceImpl implements UsuarioClienteService {

    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public boolean existeUsuario(String usuario) {
        return usuarioClienteRepository.existeUsuario(usuario);
    }

    public boolean passwordCheck(UsuarioCliente usuario) {
        String password = usuarioClienteRepository.getPasswords(usuario.getUserName());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(usuario.getPassword(), password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UsuarioCliente update(UsuarioCliente usuario, String userName) {
        UsuarioCliente userChange = usuarioClienteRepository.getUsuario(userName);
        userChange.setUserName(usuario.getUserName());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userChange.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioClienteRepository.save(userChange);
    }

    @Override
    public Cliente login(UsuarioCliente usuario) {
        if (this.passwordCheck(usuario)) {
            Long id = usuarioClienteRepository.verifyId(usuario.getUserName());
            return clienteRepository.getCliente(id);
        } else {
            return null;
        }
    }

    @Override
    public UsuarioCliente save(UsuarioCliente usuario) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioClienteRepository.save(usuario);
    }
}
