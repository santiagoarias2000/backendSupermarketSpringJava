package com.usta.dos012.servicios;


import com.usta.dos012.model.pedidoCliente;
import com.usta.dos012.repositorios.pedidoClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class pedidoClienteServicio {
    @Autowired
    private pedidoClienteRepositorio pedidoClienteRepositorio;

    public List<pedidoCliente> listarPedidoCliente(){return pedidoClienteRepositorio.findAll();}

    public pedidoCliente crearPedidoCliente(pedidoCliente pedidoCliente){return pedidoClienteRepositorio.save(pedidoCliente);}

    public Optional<pedidoCliente> buscarId(Long id){return pedidoClienteRepositorio.findById(id);}

    public void borrarId(Long id){pedidoClienteRepositorio.deleteById(id);}

    public Integer contarTotalPedidoCliente(){return pedidoClienteRepositorio.contarTotalPedidoCliente();}
}
