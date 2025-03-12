package com.netec.GestionProductos.controller;

import com.netec.GestionProductos.entities.Producto;
import com.netec.GestionProductos.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping()
    public List<Producto> listar(){
        return productosService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Integer id){
        Optional<Producto> productoOptional = productosService.listById(id);
        if(productoOptional.isPresent()){
            return ResponseEntity.ok(productoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> eliminarProducto(@PathVariable Integer id) {
        Optional<Producto> productoOptional = productosService.listById(id);
        if (productoOptional.isPresent()){
            productosService.delete(id);
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.notFound().build();
    }
}
