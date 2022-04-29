package com.usta.dos012.repositorios;

import com.usta.dos012.model.pedidoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface pedidoClienteRepositorio extends JpaRepository<pedidoCliente, Long> {
    @Query("select count(pedc) from pedidoCliente pedc")
    public Integer contarTotalPedidoCliente();
}
