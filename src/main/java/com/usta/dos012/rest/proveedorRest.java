package com.usta.dos012.rest;


import com.usta.dos012.model.Proveedor;
import com.usta.dos012.servicios.proveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedor")
public class proveedorRest {

    @Autowired
    private proveedorServicio proveedorServicio;

    @GetMapping("listarProveedor")
    private ResponseEntity<List<Proveedor>> listarProveedor(){
        return ResponseEntity.ok(proveedorServicio.listarProveedor());
    }

    @PostMapping("crearProveedor")
    private ResponseEntity<Proveedor> guardarProveedor(@RequestBody Proveedor proveedor){
        Proveedor temporal = proveedorServicio.crearProveedor(proveedor);
        try{
            return ResponseEntity.created(new URI("/api/proveedor" + temporal.getIdProveedor())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "listarproveedor/{id}")
    private ResponseEntity<Optional<Proveedor>> listarProveedorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(proveedorServicio.buscarId(id));
    }

    @DeleteMapping("delete/{id}")
    private ResponseEntity<String> borrarProveedor(@PathVariable("id") Long id){
        proveedorServicio.borrarId(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/edit")
    private ResponseEntity<Proveedor> editarProveedor(@RequestBody Proveedor proveedor){
        Proveedor temporal = proveedorServicio.crearProveedor(proveedor);
        try{
            return ResponseEntity.created(new URI("/api/proveedor" + temporal.getIdProveedor())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/totalProveedor")
    private ResponseEntity<String> listarTotalProveedor(){
        return ResponseEntity.ok("El total de los proveedores es de: "+String.valueOf(proveedorServicio.contarTotalProveedor()));
    }
}
