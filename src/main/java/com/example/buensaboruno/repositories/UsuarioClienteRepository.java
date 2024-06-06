package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.UsuarioCliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioClienteRepository extends BaseRepository<UsuarioCliente,Long> {
    @Query(value = "SELECT EXISTS (SELECT 1 FROM USUARIO_CLIENTE WHERE USER_NAME = :usuario)", nativeQuery = true)
    public boolean existeUsuario(@Param("usuario") String usuario);

    @Query(value = "SELECT PASSWORD FROM USUARIO_CLIENTE WHERE USER_NAME = :usuario", nativeQuery = true)
    public String getPasswords(@Param("usuario") String usuario);

    @Query(value = "SELECT * FROM USUARIO_CLIENTE WHERE USER_NAME = :usuario", nativeQuery = true)
    public UsuarioCliente getUsuario(@Param("usuario") String usuario);

    @Query(value = "SELECT EXIST (SELECT 1 FROM USUARIO_CLIENTE WHERE USER_NAME = :usuario AND PASSWORD = :password)", nativeQuery = true)
    public boolean verify(@Param("usuario") String usuario, @Param("password") String password);

    @Query(value = "SELECT ID FROM USUARIO_CLIENTE WHERE USER_NAME = ?1", nativeQuery = true)
    public Long verifyId(String userName);
}
