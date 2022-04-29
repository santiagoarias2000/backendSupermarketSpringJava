package com.usta.dos012.rest;

import com.usta.dos012.model.Factura;
import com.usta.dos012.servicios.facturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/factura")
public class facturaRest {
    @Autowired
    private facturaServicio facturaServicio;

    @GetMapping("listarFactura")
    private ResponseEntity<List<Factura>> listarFactura(){
        return ResponseEntity.ok(facturaServicio.listarFactura());
    }

    @PostMapping("crearFactura")
    private ResponseEntity<Factura> guardarFactura(@RequestBody Factura factura){
        Factura temporal = facturaServicio.crearFactura(factura);
        try{
            return ResponseEntity.created(new URI("/api/factura" + temporal.getIdFactura())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "listarfactura/{id}")
    private ResponseEntity<Optional<Factura>> listarFactura(@PathVariable("id") Long id){
        return ResponseEntity.ok(facturaServicio.buscarId(id));
    }

    @DeleteMapping("delete/{id}")
    private ResponseEntity<String> borrarFactura(@PathVariable("id") Long id){
        facturaServicio.borrarId(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/edit")
    private ResponseEntity<Factura> editarFactura(@RequestBody Factura factura){
        Factura temporal = facturaServicio.crearFactura(factura);
        try{
            return ResponseEntity.created(new URI("/api/factura" + temporal.getIdFactura())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/totalFactura")
    private ResponseEntity<String> listarTotalFactura(){
        return ResponseEntity.ok("el total de las facturas es de: "+String.valueOf(facturaServicio.contarTotalFactura()));
    }
}
