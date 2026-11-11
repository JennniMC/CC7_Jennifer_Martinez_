package com.example.H2R_Jennifer_Janet_CC7.controller;

import com.example.H2R_Jennifer_Janet_CC7.controller.dto.CreatePedidoDTO;
import com.example.H2R_Jennifer_Janet_CC7.model.Pedido;
import com.example.H2R_Jennifer_Janet_CC7.model.Producto;
import com.example.H2R_Jennifer_Janet_CC7.service.MyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/service")
@CrossOrigin("*")
public class MyController {
    private final MyService servicio;
    public MyController(MyService servicio){
        this.servicio=servicio;
    }
    @PostMapping("/crear")
    public ResponseEntity<Pedido>CrearPedido(@RequestBody @Valid CreatePedidoDTO payload){
     return ResponseEntity.status(200).body(servicio.CrearPedido(payload));
    }
    @PatchMapping("/cancelar/{id}")
    public ResponseEntity<Pedido>CancelarPedido(Long id){
        return ResponseEntity.status(200).body(servicio.CancelarPedido(id));
    }
    @PatchMapping("/cancelar-Producto/{id}")
    public ResponseEntity<Pedido>ProcesarPedido(Long id){
        return ResponseEntity.status(200).body(servicio.ProcesarPedido(id));
    }
    @PatchMapping("/desactivar/{id}")
    public ResponseEntity<Producto>DesactivarProducto(Long id){
        return ResponseEntity.status(200).body(servicio.DesactivarProducto(id));
    }

}
