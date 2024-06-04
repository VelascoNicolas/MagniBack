package com.example.buensaboruno.services.impl;

import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.repositories.CategoriaRepository;
import com.example.buensaboruno.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional
    public List<Categoria> getTodas() {
        List<Categoria> todas = categoriaRepository.findAll();
        List<Categoria> sinSubs = new ArrayList<Categoria>();
        for (Categoria c : todas) {
            if (c.getSubCategorias().isEmpty()) {
                sinSubs.add(c);
            }
        }
        return sinSubs;
    }
}
