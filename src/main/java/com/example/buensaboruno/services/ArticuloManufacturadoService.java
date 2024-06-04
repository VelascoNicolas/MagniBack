package com.example.buensaboruno.services;

import com.example.buensaboruno.domain.entities.ArticuloManufacturado;

import java.util.List;

public interface ArticuloManufacturadoService {
    public ArticuloManufacturado getById(Long id);
    public List<ArticuloManufacturado> getTodos();
    public ArticuloManufacturado save(ArticuloManufacturado articulo);
    public String delete(Long idArticulo);
    public ArticuloManufacturado edit(ArticuloManufacturado articuloE);
}
