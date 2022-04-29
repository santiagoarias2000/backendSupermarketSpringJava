package com.usta.dos012.servicios;

import com.usta.dos012.model.Cliente;
import com.usta.dos012.repositorios.clienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clienteServicio {
    @Autowired
    private clienteRepositorio clienteRepositorio;

    public List<Cliente> listarCliente(){return clienteRepositorio.findAll();}

    public Cliente crearCliente(Cliente cliente){return clienteRepositorio.save(cliente);}

    public Optional<Cliente> buscarId(Long id){return clienteRepositorio.findById(id);}

    public void borrarId(Long id){clienteRepositorio.deleteById(id);}

    public Integer contarTotalCliente(){return clienteRepositorio.contarTotalCliente();}
}
