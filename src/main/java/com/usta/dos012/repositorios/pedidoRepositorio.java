package com.usta.dos012.repositorios;

import com.usta.dos012.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface pedidoRepositorio extends JpaRepository<Pedido, Long> {
    @Query("select count(ped) from Pedido ped")
    public Integer contarTotalPedido();
}
