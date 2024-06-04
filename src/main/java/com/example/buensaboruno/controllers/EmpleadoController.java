package com.example.buensaboruno.controllers;

import com.example.buensaboruno.services.impl.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoServiceImpl empleadoService;

    @GetMapping
    public ResponseEntity<List<?>> getEmpleados() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empleadoService.getTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonList("ERROR FATAL EMPLEADOS"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmpleadoById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empleadoService.getByID(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("ERROR FATAL EMPLEADO ID");
        }
    }
}
