package com.usta.dos012.rest;


import com.usta.dos012.model.Pedido;
import com.usta.dos012.servicios.pedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedido")
public class pedidoRest {
    @Autowired
    private pedidoServicio pedidoServicio;

    @GetMapping("listarPedido")
    private ResponseEntity<List<Pedido>> listarPedido(){
        return ResponseEntity.ok(pedidoServicio.listarPedido());
    }

    @PostMapping("crearPedido")
    private ResponseEntity<Pedido> guardarPedido(@RequestBody Pedido pedido){
        Pedido temporal = pedidoServicio.crearPedido(pedido);
        try{
            return ResponseEntity.created(new URI("/api/pedido" + temporal.getIdPedido())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "listarpedido/{id}")
    private ResponseEntity<Optional<Pedido>> listarPedido(@PathVariable("id") Long id){
        return ResponseEntity.ok(pedidoServicio.buscarId(id));
    }

    @DeleteMapping("delete/{id}")
    private ResponseEntity<String> borrarPedido(@PathVariable("id") Long id){
        pedidoServicio.borrarId(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/edit")
    private ResponseEntity<Pedido> editarPedido(@RequestBody Pedido pedido){
        Pedido temporal = pedidoServicio.crearPedido(pedido);
        try{
            return ResponseEntity.created(new URI("/api/pedido" + temporal.getIdPedido())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/totalPedido")
    private ResponseEntity<String> listarTotalPedido(){
        return ResponseEntity.ok("El total del pedido es de: "+String.valueOf(pedidoServicio.contarTotalPedido()));
    }
}
