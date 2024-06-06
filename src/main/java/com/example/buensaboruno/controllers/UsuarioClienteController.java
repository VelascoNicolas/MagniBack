package com.example.buensaboruno.controllers;


import com.example.buensaboruno.domain.entities.UsuarioCliente;
import com.example.buensaboruno.services.UsuarioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("usuarios")
public class UsuarioClienteController {

    @Autowired
    private UsuarioClienteService usuarioClienteService;

    @GetMapping("/{userName}")
    public ResponseEntity<?> getUsuarioByUserName(@PathVariable String userName) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioClienteService.existeUsuario(userName));
    }

    @PostMapping
    public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioCliente usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioClienteService.save(usuario));
    }

    @GetMapping("/password")
    public ResponseEntity<?> getPassword(@RequestBody UsuarioCliente usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioClienteService.passwordCheck(usuario));
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUsuario(@RequestBody UsuarioCliente usuario, @PathVariable String userName) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioClienteService.update(usuario, userName));
    }

    @GetMapping("/cliente")
    public ResponseEntity<?> getUsuarioByUserNameAndPassword(@RequestBody UsuarioCliente usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioClienteService.login(usuario));
    }
}
