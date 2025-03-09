package com.netec.GestionProductos.controller;

import com.netec.GestionProductos.entities.Producto;
import com.netec.GestionProductos.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
