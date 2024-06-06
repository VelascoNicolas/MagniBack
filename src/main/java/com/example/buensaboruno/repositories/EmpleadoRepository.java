package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.domain.entities.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado,Long> {
    @Query(value = "SELECT *\n" +
            "FROM EMPLEADO\n" +
            "WHERE ACTIVO = TRUE\n" +
            "LIMIT 1;", nativeQuery = true)
    public Empleado findByActivo();
}
