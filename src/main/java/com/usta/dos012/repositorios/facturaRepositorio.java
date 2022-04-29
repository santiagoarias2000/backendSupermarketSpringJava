package com.usta.dos012.repositorios;

import com.usta.dos012.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface facturaRepositorio extends JpaRepository<Factura, Long> {
    @Query("select count(fact) from Factura fact")
    public Integer contarTotalFactura();
}
