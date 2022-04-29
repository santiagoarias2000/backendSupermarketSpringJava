package com.usta.dos012.repositorios;

import com.usta.dos012.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface clienteRepositorio extends JpaRepository<Cliente, Long> {
    @Query("select count(clie) from Cliente clie")
    public Integer contarTotalCliente();
}
