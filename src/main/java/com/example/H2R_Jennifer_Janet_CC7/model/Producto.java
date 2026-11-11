package com.example.H2R_Jennifer_Janet_CC7.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //nombre
    private String nombre;
    //categoria
    private String categoria;
    //precio (Double)
    private double precio;
    //stock (Integer)
    private int stock;
    //activo (boolean)
    private boolean activo;
    private Pedido pedido;
}
