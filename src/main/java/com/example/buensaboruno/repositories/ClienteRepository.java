package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Base;
import com.example.buensaboruno.domain.entities.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente,Long> {
    @Query(value = "SELECT * FROM CLIENTE WHERE USUARIO_ID = :id", nativeQuery = true)
    public Cliente getCliente(@Param("id") Long id);

}
