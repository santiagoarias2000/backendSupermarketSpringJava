package com.usta.dos012.repositorios;

import com.usta.dos012.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface proveedorRepositorio extends JpaRepository<Proveedor, Long> {
    @Query("select count(prov) from Proveedor prov")
    public Integer contarTotalProveedor();
}
