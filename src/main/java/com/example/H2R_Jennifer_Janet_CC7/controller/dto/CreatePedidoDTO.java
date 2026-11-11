package com.example.H2R_Jennifer_Janet_CC7.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePedidoDTO {
   // Recibir el ID del producto, nombre del cliente y cantidad solicitada.
    @NotBlank
    private Long id;
    @NotBlank
    private String nombreCliente;
    @NotBlank
    private int cantidad;
}
