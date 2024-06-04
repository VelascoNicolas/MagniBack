package com.example.buensaboruno.controllers;

import com.example.buensaboruno.services.impl.CategoriaServiceImpl;
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
@RequestMapping(path = "categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @GetMapping("")
    public ResponseEntity<List<?>> getTodas() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getTodas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonList("ERROR FATAL CATEGORIAS?"));
        }
    }
}
