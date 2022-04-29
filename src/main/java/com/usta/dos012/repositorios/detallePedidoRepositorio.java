package com.usta.dos012.repositorios;

import com.usta.dos012.model.detallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface detallePedidoRepositorio extends JpaRepository<detallePedido, Long> {
    @Query("select count(deta) from detallePedido deta")
    public Integer contarTotalDetallePedido();
}
