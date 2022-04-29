package com.usta.dos012.servicios;

import com.usta.dos012.model.Pedido;
import com.usta.dos012.repositorios.pedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class pedidoServicio {
    @Autowired
    private pedidoRepositorio pedidoRepositorio;

    public List<Pedido> listarPedido(){return pedidoRepositorio.findAll();}

    public Pedido crearPedido(Pedido pedido){return pedidoRepositorio.save(pedido);}

    public Optional<Pedido> buscarId(Long id){return pedidoRepositorio.findById(id);}

    public void borrarId(Long id){pedidoRepositorio.deleteById(id);}

    public Integer contarTotalPedido(){return pedidoRepositorio.contarTotalPedido();}
}
