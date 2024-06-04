package com.example.buensaboruno.services;

import com.example.buensaboruno.domain.DTO.PedidoDTO;
import com.example.buensaboruno.domain.entities.Pedido;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface PedidoService {
    public List<Pedido> getTodos();
    public Pedido getByID(Long id);
    public Pedido guardarPedido(PedidoDTO pedido, LocalDate fechaActual, Double precioDelivery);
}
