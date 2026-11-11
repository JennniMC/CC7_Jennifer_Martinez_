package com.example.H2R_Jennifer_Janet_CC7.repository;

import com.example.H2R_Jennifer_Janet_CC7.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
