package com.example.H2R_Jennifer_Janet_CC7.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter@NoArgsConstructor

@Table(name = "Pedido")
public class Pedido {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //nombreCliente
    private String nombreCliente;
    //cantidad (Integer)
    private int Cantidad;
    //precioUnitario (Double)
    private double precioUnitario;
    //total (Double)
    private double total;
    //estado (PENDIENTE, PROCESADO, CANCELADO)
    @Enumerated(EnumType.STRING)
    private Estado estado;
    //producto (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "id_Producto")
    private Producto producto;
}
