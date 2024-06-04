package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.UsuarioCliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioClienteRepository extends BaseRepository<UsuarioCliente,Long> {
    @Query(value = "SELECT EXISTS (SELECT 1 FROM USUARIO_CLIENTE WHERE USER_NAME = :usuario)", nativeQuery = true)
    public boolean existeUsuario(@Param("usuario") String usuario);
}
