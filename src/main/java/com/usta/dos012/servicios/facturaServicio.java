package com.usta.dos012.servicios;


import com.usta.dos012.model.Factura;
import com.usta.dos012.repositorios.facturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class facturaServicio {
    @Autowired
    private facturaRepositorio facturaRepositorio;

    public List<Factura> listarFactura(){return facturaRepositorio.findAll();}

    public Factura crearFactura(Factura factura){return facturaRepositorio.save(factura);}

    public Optional<Factura> buscarId(Long id){return facturaRepositorio.findById(id);}

    public void borrarId(Long id){facturaRepositorio.deleteById(id);}

    public Integer contarTotalFactura(){return facturaRepositorio.contarTotalFactura();}
}
