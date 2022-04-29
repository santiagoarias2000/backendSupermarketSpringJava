package com.usta.dos012.servicios;

import com.usta.dos012.model.Producto;
import com.usta.dos012.repositorios.productoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productoServicio {
    @Autowired
    private productoRepositorio productoRepositorio;

    public List<Producto> listarProducto(){return productoRepositorio.findAll();}

    public Producto crearProducto(Producto producto){return productoRepositorio.save(producto);}

    public Optional<Producto> buscarId(Long id){return productoRepositorio.findById(id);}

    public void borrarId(Long id){productoRepositorio.deleteById(id);}

    public Integer contarTotalProducto(){return productoRepositorio.contarTotalProducto();}
}
