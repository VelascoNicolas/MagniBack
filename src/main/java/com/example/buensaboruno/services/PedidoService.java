package com.example.buensaboruno.services;

import com.example.buensaboruno.domain.entities.Pedido;

import java.util.List;

public interface PedidoService {
    public List<Pedido> getTodos();
    public Pedido getByID(Long id);
}
