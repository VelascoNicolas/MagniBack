package com.example.buensaboruno.services.impl;

import com.example.buensaboruno.domain.entities.Empleado;
import com.example.buensaboruno.repositories.EmpleadoRepository;
import com.example.buensaboruno.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> getTodos() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getByID(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }
}
