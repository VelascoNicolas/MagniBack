package com.example.buensaboruno.services.impl;

import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.repositories.ArticuloInsumoRepository;
import com.example.buensaboruno.services.ArticuloInsumoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloInsumoServiceImpl implements ArticuloInsumoService {

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;


    @Override
    @Transactional
    public List<ArticuloInsumo> getElaborados() {
        return articuloInsumoRepository.getElaborados();
    }
}
