package com.netec.GestionProductos.controller;

import com.netec.GestionProductos.entities.Producto;
import com.netec.GestionProductos.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {

    @Autowired
    ProductosService productosService;

    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {

        if (Objects.isNull(producto.getNombre()) || "".equalsIgnoreCase(producto.getNombre())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Debe ingresar Nombre del Producto");
        }

        if (Objects.isNull(producto.getDescripcion()) || "".equalsIgnoreCase(producto.getDescripcion())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Debe ingresar Descripcion del Producto");
        }

        if (Objects.isNull(producto.getPrecio()) || producto.getPrecio() <= 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Debe ingresar Precio del Producto");
        }

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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProducto (@PathVariable Integer id, @RequestBody Producto producto) {
        if (Objects.isNull(producto.getNombre()) || "".equalsIgnoreCase(producto.getNombre())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Debe ingresar Nombre del Producto");
        }

        if (Objects.isNull(producto.getDescripcion()) || "".equalsIgnoreCase(producto.getDescripcion())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Debe ingresar Descripcion del Producto");
        }

        if (Objects.isNull(producto.getPrecio()) || producto.getPrecio() <= 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Debe ingresar Precio del Producto");
        }

        Optional<Producto> productoBD = productosService.listById(id);

        if (productoBD.isPresent()) {
            /*return productosService.listById(id)
                    .map(product -> {
                        product.setNombre(producto.getNombre());
                        product.setDescripcion(producto.getDescripcion());
                        product.setPrecio(producto.getPrecio());
                        Producto updatedProducto = productosService.save(product);
                        return ResponseEntity.ok(updatedProducto);
                    })
                    .orElse(ResponseEntity.notFound().build());*/
            Producto actualizarProducto = productosService.updateProducto(id, producto);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(actualizarProducto);
        }

        return ResponseEntity.notFound().build();
    }
}
