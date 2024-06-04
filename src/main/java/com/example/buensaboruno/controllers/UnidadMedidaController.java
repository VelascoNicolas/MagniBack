package com.example.buensaboruno.controllers;

import com.example.buensaboruno.services.impl.UnidadMedidaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path = "unidades")
public class UnidadMedidaController {

    @Autowired
    private UnidadMedidaServiceImpl unidadMedidaService;

    @GetMapping("")
    public ResponseEntity<List<?>> getTodos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(unidadMedidaService.getTodo());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonList("ERROR FATAL UNIDADES?"));
        }
    }
}
