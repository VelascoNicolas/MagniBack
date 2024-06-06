package com.example.buensaboruno.services;

import com.example.buensaboruno.domain.entities.Empleado;

import java.util.List;

public interface EmpleadoService {
    public List<Empleado> getTodos();
    public Empleado getByID(Long id);
    public Empleado getByActivo();
}
