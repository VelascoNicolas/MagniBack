package com.example.buensaboruno.controllers;

import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.services.impl.ArticuloManufacturadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "articulos")
public class ArticuloManufacturadoController {

    @Autowired
    private ArticuloManufacturadoServiceImpl artiService;

    @GetMapping("")
    public ResponseEntity<List<?>> getTodos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(artiService.getTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonList("Error Fatal GetAll"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(artiService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error Fatal Get By ID");
        }
    }

    @PostMapping(value = "", consumes={"application/json"})
    public ResponseEntity<?> save(@RequestBody ArticuloManufacturado articulo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(artiService.save(articulo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error Fatal SAVE");
        }
    }

    @PutMapping(value = "", consumes={"application/json"})
    public ResponseEntity<?> edit(@RequestBody ArticuloManufacturado articuloE) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(artiService.edit(articuloE));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error Fatal EDIT");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(artiService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
