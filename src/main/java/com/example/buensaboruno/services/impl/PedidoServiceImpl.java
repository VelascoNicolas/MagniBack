package com.example.buensaboruno.services.impl;

import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.repositories.PedidoRepository;
import com.example.buensaboruno.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public List<Pedido> getTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    @Transactional
    public Pedido getByID(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }
}
