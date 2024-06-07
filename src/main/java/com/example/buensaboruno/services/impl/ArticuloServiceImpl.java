package com.example.buensaboruno.services.impl;

import com.example.buensaboruno.domain.entities.Articulo;
import com.example.buensaboruno.repositories.ArticuloRepository;
import com.example.buensaboruno.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public Articulo getById(Long id) {
        return articuloRepository.findById(id).orElse(null);
    }
}
