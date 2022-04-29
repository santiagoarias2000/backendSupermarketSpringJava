package com.usta.dos012.rest;


import com.usta.dos012.model.detallePedido;
import com.usta.dos012.servicios.detallePedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detPedido")
public class detallePedidoRest {
    @Autowired
    private detallePedidoServicio detallePedidoServicio;

    @GetMapping("listarDetPedido")
    private ResponseEntity<List<detallePedido>> listarDetPedido(){
        return ResponseEntity.ok(detallePedidoServicio.listarDetallePedido());
    }

    @PostMapping("crearDetPedido")
    private ResponseEntity<detallePedido> guardarDetPedido(@RequestBody detallePedido detallePedido){
        detallePedido temporal = detallePedidoServicio.crearDetallePedido(detallePedido);
        try{
            return ResponseEntity.created(new URI("/api/detPedido" + temporal.getIdDetallePedido())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "listardetpedido/{id}")
    private ResponseEntity<Optional<detallePedido>> listarDetPedidoId(@PathVariable("id") Long id){
        return ResponseEntity.ok(detallePedidoServicio.buscarId(id));
    }

    @DeleteMapping("delete/{id}")
    private ResponseEntity<String> borrarDetPedido(@PathVariable("id") Long id){
        detallePedidoServicio.borrarId(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/edit")
    private ResponseEntity<detallePedido> editarDetPedido(@RequestBody detallePedido detallePedido){
        detallePedido temporal = detallePedidoServicio.crearDetallePedido(detallePedido);
        try{
            return ResponseEntity.created(new URI("/api/detPedido" + temporal.getIdDetallePedido())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/totalDetPedido")
    private ResponseEntity<String> listarTotalDetPedido(){
        return ResponseEntity.ok("El total de pedidos es de: "+String.valueOf(detallePedidoServicio.contarTotalDetallePedido()));
    }
}
