package com.example.buensaboruno.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
//@Audited
public class DetallePedido extends Base{
    private Integer cantidad;
    private Double subTotal;

    @ManyToOne
    private Articulo articulo;

    @ManyToOne
    private Promocion promocion;

    public Double calcularSubTotal() {
        Double subtotal = 0.0;
        if (this.getArticulo() instanceof ArticuloInsumo) {
            subtotal = this.getCantidad() * ((ArticuloInsumo) this.getArticulo()).getPrecioVenta();
        } else if (this.getArticulo() instanceof ArticuloManufacturado) {
            subtotal = this.getCantidad() * ((ArticuloManufacturado) this.getArticulo()).getPrecioVenta();
        }
        this.setSubTotal(subtotal);
        return subtotal;
    }

}
