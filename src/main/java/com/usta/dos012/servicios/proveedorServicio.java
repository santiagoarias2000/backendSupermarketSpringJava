package com.usta.dos012.servicios;


import com.usta.dos012.model.Proveedor;
import com.usta.dos012.repositorios.proveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class proveedorServicio {
    @Autowired
    private proveedorRepositorio proveedorRepositorio;

    public List<Proveedor> listarProveedor(){return proveedorRepositorio.findAll();}

    public Proveedor crearProveedor(Proveedor proveedor){return proveedorRepositorio.save(proveedor);}

    public Optional<Proveedor> buscarId(Long id){return proveedorRepositorio.findById(id);}

    public void borrarId(Long id){proveedorRepositorio.deleteById(id);}

    public Integer contarTotalProveedor(){return proveedorRepositorio.contarTotalProveedor();}
}
