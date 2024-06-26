package com.example.buensaboruno.controllers;

import com.example.buensaboruno.domain.DTO.PedidoDTO;
import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.services.impl.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
@RestController
@CrossOrigin(value = "*")
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl pedidoService;

    @GetMapping("")
    public ResponseEntity<List<?>> getPedidos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(pedidoService.getTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonList("ERROR FATAL PEDIDOS"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPedidoById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(pedidoService.getByID(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("ERROR FATAL PEDIDO ID");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> guardarPedido(@RequestBody PedidoDTO pedido,
                                           @RequestParam(value = "horaActual", required = false)LocalTime horaActual,
                                           @RequestParam(value = "fechaActual", required = false) LocalDate fechaActual,
                                           @RequestParam(value = "precioDelivery", required = false) Double precioDelivery) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(pedidoService.guardarPedido(pedido, fechaActual, precioDelivery));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("ERROR FATAL PEDIDO");
        }
    }
}
