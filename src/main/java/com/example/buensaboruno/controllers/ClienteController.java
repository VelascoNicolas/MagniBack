package com.example.buensaboruno.controllers;

import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> getTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.getTodas());
    }

    @PostMapping
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
    }
}
