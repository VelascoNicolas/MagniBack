package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends JpaRepository<ArticuloManufacturado,Long> {
    @Query(value = "SELECT *\n" +
            "FROM ARTICULO_MANUFACTURADO\n" +
            "INNER JOIN ARTICULO\n" +
            "ON ARTICULO_MANUFACTURADO.ID = ARTICULO.ID WHERE ELIMINADO = FALSE", nativeQuery = true)
    List<ArticuloManufacturado> getTodos();
}
