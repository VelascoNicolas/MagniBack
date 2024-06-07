package com.example.buensaboruno.services.impl;

import com.example.buensaboruno.domain.entities.Promocion;
import com.example.buensaboruno.repositories.PromocionRepository;
import com.example.buensaboruno.services.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromocionServiceImpl implements PromocionService {

    @Autowired
    private PromocionRepository promocionRepository;

    @Override
    public Promocion getById(Long id) {
        return promocionRepository.findById(id).orElse(null);
    }
}
