package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.ArticuloManufacturadoDetalle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ArticuloManufacturadoDetalleRepository extends BaseRepository<ArticuloManufacturadoDetalle,Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE ARTICULO_MANUFACTURADO_DETALLE SET ELIMINADO = true WHERE ARTICULO_MANUFACTURADO_ID = ?1", nativeQuery = true)
    void logicDelete(Long id);
}
