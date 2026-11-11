package com.example.H2R_Jennifer_Janet_CC7.service;

import com.example.H2R_Jennifer_Janet_CC7.controller.dto.CreatePedidoDTO;
import com.example.H2R_Jennifer_Janet_CC7.model.Estado;
import com.example.H2R_Jennifer_Janet_CC7.model.Pedido;
import com.example.H2R_Jennifer_Janet_CC7.model.Producto;
import com.example.H2R_Jennifer_Janet_CC7.repository.PedidoRepository;
import com.example.H2R_Jennifer_Janet_CC7.repository.ProductoRepository;
import org.springframework.stereotype.Service;



@Service
public class MyService {
    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    public MyService(PedidoRepository pedidoRepository, ProductoRepository productoRepository){
        this.productoRepository=productoRepository;
        this.pedidoRepository=pedidoRepository;
    }

    public Pedido CrearPedido(CreatePedidoDTO payload){

       Producto producto= productoRepository.findById(payload.getId()).orElseThrow(
                ()->new RuntimeException("El id no existe")
        );
       if(!producto.isActivo()){
           throw new RuntimeException("El producto no esta activo");
       }
       Pedido pedido=new Pedido();
       if(pedido.getCantidad()<0){
           throw new RuntimeException("No hay producto en existencia");
       }
       if(producto.getStock()<pedido.getCantidad()){
           throw new RuntimeException("No hay suficiente stock");
       }
       double total=pedido.getPrecioUnitario()*pedido.getCantidad();
       pedido.setNombreCliente(payload.getNombreCliente());
       pedido.setCantidad(payload.getCantidad());
      pedido.setTotal(total);
      pedido.setEstado(Estado.PENDIENTE);
        producto.setId(payload.getId());
        productoRepository.save(producto);

return pedidoRepository.save(pedido);
    }
    public Pedido CancelarPedido(Long id){
        Producto producto=new Producto();
        Pedido pedido= pedidoRepository.findById(id).orElseThrow(
                ()->new RuntimeException("El id no existe")
        );
        if (pedido.getEstado() != Estado.PENDIENTE){
            throw new RuntimeException("Solo se pueden cancelar pedidos con estado pendiente");
        }
        pedido.setEstado(Estado.CANCELADO);
        producto.setStock(pedido.getCantidad());
        productoRepository.save(producto);

        return pedidoRepository.save(pedido);
    }
    public Pedido ProcesarPedido(Long id){
        Pedido pedido= pedidoRepository.findById(id).orElseThrow(
                ()->new RuntimeException("El id no existe")
        );
        if (pedido.getEstado() != Estado.PENDIENTE){
            throw new RuntimeException("Solo se pueden procesar pedidos con estado pendiente");
        }
        pedido.setEstado(Estado.PROCESADO);

        return pedidoRepository.save(pedido);
    }

    public Producto DesactivarProducto(Long id){
        Producto producto= productoRepository.findById(id).orElseThrow(
                ()->new RuntimeException("El id no existe")
        );
        Pedido pedido=new Pedido();
        if (pedido.getEstado() != Estado.PENDIENTE){
            throw new RuntimeException("Solo se pueden desactivar pedidos con estado pendiente");
        }
        pedidoRepository.save(pedido);
        producto.setActivo(false);
        return productoRepository.save(producto);
    }
}

