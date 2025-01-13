package com.espe.ordencompra.controllers;

import com.espe.ordencompra.models.entities.OrdenCompra;
import com.espe.ordencompra.services.OrdenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService service;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody OrdenCompra orden, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), err.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errores);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(orden));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<OrdenCompra> ordenOptional = service.findById(id);
        if (ordenOptional.isPresent()) {
            return ResponseEntity.ok().body(ordenOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody OrdenCompra orden, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), err.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errores);
        }

        Optional<OrdenCompra> ordenOptional = service.findById(id);
        if (ordenOptional.isPresent()) {
            OrdenCompra ordenDB = ordenOptional.get();
            ordenDB.setProvedoor(orden.getProvedoor());
            ordenDB.setDescripcion(orden.getDescripcion());
            ordenDB.setCantidad(orden.getCantidad());
            ordenDB.setFechaOrden(orden.getFechaOrden());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(ordenDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<OrdenCompra> ordenOptional = service.findById(id);
        if (ordenOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Orden de compra no encontrada para eliminar");
        }
    }
}
