package com.netec.GestionProductos.controller;

import com.netec.GestionProductos.entities.Producto;
import com.netec.GestionProductos.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {

    @Autowired
    ProductosService productosService;

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto guardarProducto = productosService.save(producto);

        return ResponseEntity.status(HttpStatus.CREATED).body(guardarProducto);
    }

    @GetMapping("/listar")
    public List<Producto> listar(){
        return productosService.list();
    }
}
