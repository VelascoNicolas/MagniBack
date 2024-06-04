package com.example.buensaboruno.services.impl;

import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.domain.entities.ArticuloManufacturadoDetalle;
import com.example.buensaboruno.repositories.ArticuloManufacturadoDetalleRepository;
import com.example.buensaboruno.repositories.ArticuloManufacturadoRepository;
import com.example.buensaboruno.repositories.ImagenArticuloRepository;
import com.example.buensaboruno.services.ArticuloManufacturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ArticuloManufacturadoServiceImpl implements ArticuloManufacturadoService {

    @Autowired
    private ArticuloManufacturadoRepository artRepository;

    @Autowired
    private ImagenArticuloRepository imagenRepository;

    @Autowired
    private ArticuloManufacturadoDetalleRepository detalleRepository;

    @Override
    @Transactional
    public ArticuloManufacturado getById(Long id) {
        return artRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<ArticuloManufacturado> getTodos() {
        return artRepository.getTodos();
    }

    @Override
    @Transactional
    public ArticuloManufacturado save(ArticuloManufacturado articulo) {
        return artRepository.save(articulo);
    }

    @Override
    @Transactional
    public String delete(Long idArticulo) {
        ArticuloManufacturado art = this.getById(idArticulo);
        art.setEliminado(true);
        detalleRepository.logicDelete(idArticulo);
        imagenRepository.deleteLogico(idArticulo);
        artRepository.save(art);
        return "ARTICULO MANUFACTURADO ELIMINADO CORRECTAMENTE";
    }

    @Override
    @Transactional
    public ArticuloManufacturado edit(ArticuloManufacturado articuloE) {
        return artRepository.save(articuloE);
    }
}
