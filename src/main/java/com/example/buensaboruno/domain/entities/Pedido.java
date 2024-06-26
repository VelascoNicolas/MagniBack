package com.example.buensaboruno.domain.entities;

import com.example.buensaboruno.domain.enums.Estado;
import com.example.buensaboruno.domain.enums.FormaPago;
import com.example.buensaboruno.domain.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.aspectj.weaver.ast.Instanceof;
import org.hibernate.envers.Audited;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
//@Audited
public class Pedido extends Base{

    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;

    @ManyToOne
    private Domicilio domicilio;

    @ManyToOne
    private Sucursal sucursal;

    @OneToOne(cascade = CascadeType.ALL)
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    //SE AGREGA EL JOIN COLUMN PARA QUE JPA NO CREE LA TABLA INTERMEDIA EN UNA RELACION ONE TO MANY
    //DE ESTA MANERA PONE EL FOREIGN KEY 'pedido_id' EN LA TABLA DE LOS MANY
    @JoinColumn(name = "pedido_id")
    //SE AGREGA EL BUILDER.DEFAULT PARA QUE BUILDER NO SOBREESCRIBA LA INICIALIZACION DE LA LISTA
    @Builder.Default
    private Set<DetallePedido> detallePedidos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    public void calcularPrecioVentaTotal(Double precioDelivery) {
        Double precioVenta = 0.0;
        for (DetallePedido detallePedido : detallePedidos) {
            precioVenta += detallePedido.calcularSubTotal();
        }
        this.setTotal(precioVenta + precioDelivery);
        this.getFactura().setTotalVenta(precioVenta + precioDelivery);
    }

    public void calcularPrecioCostoTotal() {
        Double precioCosto = 0.0;
        for (DetallePedido detallePedido : detallePedidos) {
            if (detallePedido.getArticulo() instanceof ArticuloInsumo) {
                precioCosto += ((ArticuloInsumo) detallePedido.getArticulo()).getPrecioCompra() * detallePedido.getCantidad();
            } else if (detallePedido.getArticulo() instanceof ArticuloManufacturado) {
                for (ArticuloManufacturadoDetalle am : ((ArticuloManufacturado) detallePedido.getArticulo()).getArticuloManufacturadoDetalles()) {
                    precioCosto += am.getArticuloInsumo().getPrecioCompra() * am.getCantidad() * detallePedido.getCantidad();
                }
            }
            if (detallePedido.getPromocion() != null) {
                for (PromocionDetalle promocionDetalle : detallePedido.getPromocion().getPromocionDetalles()) {
                    if (promocionDetalle.getArticulo() instanceof ArticuloInsumo) {
                        precioCosto += ((ArticuloInsumo) promocionDetalle.getArticulo()).getPrecioCompra() * promocionDetalle.getCantidad() * detallePedido.getCantidad();
                    } else if (promocionDetalle.getArticulo() instanceof ArticuloManufacturado) {
                        for (ArticuloManufacturadoDetalle am : ((ArticuloManufacturado) promocionDetalle.getArticulo()).getArticuloManufacturadoDetalles()) {
                            precioCosto += am.getArticuloInsumo().getPrecioCompra() * am.getCantidad() * detallePedido.getCantidad();
                        }
                    }
                }
            }

        }
        this.setTotalCosto(precioCosto);
    }

    public void calcularTiempoEstimadoFinalizacion(LocalTime horaActual) {
        LocalTime hora = horaActual;
        Integer maximo = 0;
        for (DetallePedido dp : detallePedidos) {
            if(dp.getArticulo() instanceof ArticuloManufacturado) {
                if (((ArticuloManufacturado) dp.getArticulo()).getTiempoEstimadoMinutos() > maximo) {
                    maximo = ((ArticuloManufacturado) dp.getArticulo()).getTiempoEstimadoMinutos();
                }
            }
            if (dp.getPromocion() != null) {
                for (PromocionDetalle promocionDetalle : dp.getPromocion().getPromocionDetalles()) {
                    if (promocionDetalle.getArticulo() instanceof ArticuloManufacturado) {
                        if (((ArticuloManufacturado) promocionDetalle.getArticulo()).getTiempoEstimadoMinutos() > maximo) {
                            maximo = ((ArticuloManufacturado) promocionDetalle.getArticulo()).getTiempoEstimadoMinutos();
                        }
                    }
                }
            }
        }

        hora = hora.plusMinutes(maximo);
        this.setHoraEstimadaFinalizacion(hora);
    }

    public void setFechasPedido(LocalDate fechaActual) {
        this.setFechaPedido(fechaActual);
        this.getFactura().setFechaFacturacion(fechaActual);
    }
}
