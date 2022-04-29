package com.usta.dos012.repositorios;

import com.usta.dos012.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface productoRepositorio extends JpaRepository<Producto, Long> {
    @Query("select count(prod) from Producto prod")
    public Integer contarTotalProducto();
}
