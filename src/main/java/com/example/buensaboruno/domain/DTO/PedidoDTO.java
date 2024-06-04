package com.example.buensaboruno.domain.DTO;

import com.example.buensaboruno.domain.entities.*;
import com.example.buensaboruno.domain.enums.Estado;
import com.example.buensaboruno.domain.enums.FormaPago;
import com.example.buensaboruno.domain.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class PedidoDTO {
    private Long id;
    private boolean eliminado;
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;

    private Domicilio domicilio;

    private Sucursal sucursal;

    private Factura factura;

    private Cliente cliente;

    @Builder.Default
    private Set<DetallePedidoDTO> detallePedidos = new HashSet<>();

    private Empleado empleado;

    public void calcularPrecioVentaTotal(Double precioDelivery) {
        Double precioVenta = 0.0;
        for (DetallePedidoDTO detallePedido : detallePedidos) {
            precioVenta += detallePedido.getSubTotal();
        }
        this.setTotal(precioVenta + precioDelivery);
        this.getFactura().setTotalVenta(precioVenta + precioDelivery);
    }
    public void setFechasPedido(LocalDate fechaActual) {
        this.setFechaPedido(fechaActual);
        this.getFactura().setFechaFacturacion(fechaActual);
    }
}
