package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.DetallePedido;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido,Long>{

    @Modifying
    @Transactional
    @Query(value = "UPDATE DETALLE_PEDIDO SET ARTICULO_ID = :articuloId WHERE ID = :id", nativeQuery = true)
    void updateArticuloId(@Param("id") Long id, @Param("articuloId") Long articuloId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE DETALLE_PEDIDO SET PROMOCION_ID = :promocionId WHERE ID = :id", nativeQuery = true)
    void updatePromocionId(@Param("id") Long id, @Param("promocionId") Long promocionId);
}
