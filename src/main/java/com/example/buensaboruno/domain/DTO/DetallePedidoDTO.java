package com.example.buensaboruno.domain.DTO;

import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class DetallePedidoDTO {
    private Long id;
    private boolean eliminado;
    private Integer cantidad;
    private Double subTotal;
    private Long articulo;
    private Long promocion;

}
