package com.example.buensaboruno.services.impl;

import com.example.buensaboruno.domain.DTO.DetallePedidoDTO;
import com.example.buensaboruno.domain.DTO.PedidoDTO;
import com.example.buensaboruno.domain.entities.DetallePedido;
import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.repositories.DetallePedidoRepository;
import com.example.buensaboruno.repositories.PedidoRepository;
import com.example.buensaboruno.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Override
    @Transactional
    public List<Pedido> getTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    @Transactional
    public Pedido getByID(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public Pedido guardarPedido(PedidoDTO pedido, LocalDate fechaActual, Double precioDelivery) {
        pedido.setFechasPedido(fechaActual);
        pedido.calcularPrecioVentaTotal(precioDelivery);
        Pedido save = new Pedido();
        save.setEliminado(pedido.isEliminado());
        save.setHoraEstimadaFinalizacion(pedido.getHoraEstimadaFinalizacion());
        save.setTotal(pedido.getTotal());
        save.setTotalCosto(pedido.getTotalCosto());
        save.setEstado(pedido.getEstado());
        save.setTipoEnvio(pedido.getTipoEnvio());
        save.setFormaPago(pedido.getFormaPago());
        save.setFechaPedido(pedido.getFechaPedido());
        save.setDomicilio(pedido.getDomicilio());
        save.setSucursal(pedido.getSucursal());
        save.setFactura(pedido.getFactura());
        save.setCliente(pedido.getCliente());
        save.setEmpleado(pedido.getEmpleado());
        for(DetallePedidoDTO dp : pedido.getDetallePedidos()) {
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setEliminado(dp.isEliminado());
            detallePedido.setCantidad(dp.getCantidad());
            detallePedido.setSubTotal(dp.getSubTotal());
            save.getDetallePedidos().add(detallePedido);
        }

        Pedido salvar = pedidoRepository.save(save);
        ArrayList<Long> ids = new ArrayList<>();
        for (DetallePedido dp : salvar.getDetallePedidos()) {
            ids.add(dp.getId());
        }
        int i = 0;
        for (DetallePedidoDTO dp : pedido.getDetallePedidos()) {
            if (dp.getArticulo() != null) {
                detallePedidoRepository.updateArticuloId(ids.get(i), dp.getArticulo());
            } else if (dp.getPromocion() != null) {
                detallePedidoRepository.updatePromocionId(ids.get(i), dp.getPromocion());
            }
            i++;
        }
        return salvar;
    }
}
