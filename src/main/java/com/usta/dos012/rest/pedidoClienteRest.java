package com.usta.dos012.rest;


import com.usta.dos012.model.pedidoCliente;
import com.usta.dos012.servicios.pedidoClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedCliente")
public class pedidoClienteRest {
    @Autowired
    private pedidoClienteServicio pedidoClienteServicio;

    @GetMapping("listarPedCliente")
    private ResponseEntity<List<pedidoCliente>> listarPedCliente(){
        return ResponseEntity.ok(pedidoClienteServicio.listarPedidoCliente());
    }

    @PostMapping("crearPedCliente")
    private ResponseEntity<pedidoCliente> guardarPedCliente(@RequestBody pedidoCliente pedidoCliente){
        pedidoCliente temporal = pedidoClienteServicio.crearPedidoCliente(pedidoCliente);
        try{
            return ResponseEntity.created(new URI("/api/pedCliente" + temporal.getIdPedidoCliente())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "listarpedcliente/{id}")
    private ResponseEntity<Optional<pedidoCliente>> listarPedCliente(@PathVariable("id") Long id){
        return ResponseEntity.ok(pedidoClienteServicio.buscarId(id));
    }

    @DeleteMapping("delete/{id}")
    private ResponseEntity<String> borrarPedCliente(@PathVariable("id") Long id){
        pedidoClienteServicio.borrarId(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/edit")
    private ResponseEntity<pedidoCliente> editarPedCliente(@RequestBody pedidoCliente pedidoCliente){
        pedidoCliente temporal = pedidoClienteServicio.crearPedidoCliente(pedidoCliente);
        try{
            return ResponseEntity.created(new URI("/api/pedCliente" + temporal.getIdPedidoCliente())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/totalPedCliente")
    private ResponseEntity<String> listarTotalPedCliente(){
        return ResponseEntity.ok("El total de pedidos es de: "+ String.valueOf(pedidoClienteServicio.contarTotalPedidoCliente()));
    }
}
