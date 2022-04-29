package com.usta.dos012.rest;

import com.usta.dos012.model.Cliente;
import com.usta.dos012.servicios.clienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class clienteRest {

    @Autowired
    private clienteServicio clienteServicio;

    @GetMapping("listarCliente")
    private ResponseEntity<List<Cliente>> listarCliente(){
        return ResponseEntity.ok(clienteServicio.listarCliente());
    }

    @PostMapping("crearCliente")
    private ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente){
        Cliente temporal = clienteServicio.crearCliente(cliente);
        try{
            return ResponseEntity.created(new URI("/api/cliente" + temporal.getIdCliente())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "listarcliente/{id}")
    private ResponseEntity<Optional<Cliente>> listarClienteId(@PathVariable("id") Long id){
        return ResponseEntity.ok(clienteServicio.buscarId(id));
    }

    @DeleteMapping("delete/{id}")
    private ResponseEntity<String> borrarCliente(@PathVariable("id") Long id){
        clienteServicio.borrarId(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/edit")
    private ResponseEntity<Cliente> editarCliente(@RequestBody Cliente cliente){
        Cliente temporal = clienteServicio.crearCliente(cliente);
        try{
            return ResponseEntity.created(new URI("/api/cliente" + temporal.getIdCliente())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/totalCliente")
    private ResponseEntity<String> listarTotalCliente(){
        return ResponseEntity.ok("El total de clientes es: "+ String.valueOf(clienteServicio.contarTotalCliente()));
    }
}
