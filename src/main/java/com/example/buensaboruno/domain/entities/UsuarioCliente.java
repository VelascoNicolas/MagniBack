package com.example.buensaboruno.domain.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
//@Audited
public class UsuarioCliente extends Base{
    private String userName;
    private String password;
}
