package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.ImagenArticulo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ImagenArticuloRepository extends BaseRepository<ImagenArticulo,Long>{
    @Transactional
    @Modifying
    @Query(value = "UPDATE IMAGEN_ARTICULO SET ELIMINADO = true WHERE ARTICULO_ID = ?1", nativeQuery = true)
    void deleteLogico(Long articuloId);


}
