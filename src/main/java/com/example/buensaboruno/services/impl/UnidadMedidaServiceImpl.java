package com.example.buensaboruno.services.impl;

import com.example.buensaboruno.domain.entities.UnidadMedida;
import com.example.buensaboruno.repositories.UnidadMedidaRepository;
import com.example.buensaboruno.services.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UnidadMedidaServiceImpl implements UnidadMedidaService {

    @Autowired
    private UnidadMedidaRepository unidadRepo;

    @Override
    @Transactional
    public List<UnidadMedida> getTodo() {
        return unidadRepo.findAll();
    }
}
