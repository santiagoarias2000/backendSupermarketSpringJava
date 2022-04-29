package com.usta.dos012.servicios;


import com.usta.dos012.model.detallePedido;
import com.usta.dos012.repositorios.detallePedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class detallePedidoServicio {
    @Autowired
    private detallePedidoRepositorio detallePedidoRepositorio;

    public List<detallePedido> listarDetallePedido(){return detallePedidoRepositorio.findAll();}

    public detallePedido crearDetallePedido(detallePedido detallePedido){return detallePedidoRepositorio.save(detallePedido);}

    public Optional<detallePedido> buscarId(Long id){return detallePedidoRepositorio.findById(id);}

    public void borrarId(Long id){detallePedidoRepositorio.deleteById(id);}

    public Integer contarTotalDetallePedido(){return detallePedidoRepositorio.contarTotalDetallePedido();}
}
