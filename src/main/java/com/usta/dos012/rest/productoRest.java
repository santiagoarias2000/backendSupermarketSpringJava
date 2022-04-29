package com.usta.dos012.rest;


import com.usta.dos012.model.Producto;
import com.usta.dos012.servicios.productoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class productoRest {
    @Autowired
    private productoServicio productoServicio;

    @GetMapping("listarProducto")
    private ResponseEntity<List<Producto>> listarProducto(){
        return ResponseEntity.ok(productoServicio.listarProducto());
    }

    @PostMapping("crearProducto")
    private ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
        Producto temporal = productoServicio.crearProducto(producto);
        try{
            return ResponseEntity.created(new URI("/api/producto" + temporal.getIdProducto())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "listarproducto/{id}")
    private ResponseEntity<Optional<Producto>> listarProducto(@PathVariable("id") Long id){
        return ResponseEntity.ok(productoServicio.buscarId(id));
    }

    @DeleteMapping("delete/{id}")
    private ResponseEntity<String> borrarProducto(@PathVariable("id") Long id){
        productoServicio.borrarId(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/edit")
    private ResponseEntity<Producto> editarProducto(@RequestBody Producto producto){
        Producto temporal = productoServicio.crearProducto(producto);
        try{
            return ResponseEntity.created(new URI("/api/producto" + temporal.getIdProducto())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/totalProducto")
    private ResponseEntity<String> listarTotalProducto(){
        return ResponseEntity.ok("El total de los productos es de: "+String.valueOf(productoServicio.contarTotalProducto()));
    }
}
