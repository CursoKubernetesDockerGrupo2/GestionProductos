package com.netec.GestionProductos.service;

import com.netec.GestionProductos.entities.Producto;
import com.netec.GestionProductos.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductosServiceImpl implements ProductosService{
    @Autowired
    ProductosRepository productosRepository;

    @Override
    public Producto save(Producto producto) {
        return productosRepository.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> list() {
        return (List<Producto>) productosRepository.findAll();
    }

    @Override
    public Optional<Producto> listById(Integer id) {
        return productosRepository.findById(id);
    }

    @Override
    public void delete (Integer id) {
        productosRepository.deleteById(id);
    }

    @Override
    public Producto updateProducto (Integer id, Producto producto) {
        Producto productoBD = productosRepository.findById(id).get();

        if (Objects.nonNull(producto.getNombre()) && ! "".equalsIgnoreCase(producto.getNombre())) {
            productoBD.setNombre(producto.getNombre());
        }

        if (Objects.nonNull(producto.getDescripcion()) && ! "".equalsIgnoreCase(producto.getDescripcion())) {
            productoBD.setDescripcion(producto.getDescripcion());
        }

        if (Objects.nonNull(producto.getPrecio()) && producto.getPrecio() > 0) {
            productoBD.setPrecio(producto.getPrecio());
        }

        return productosRepository.save(productoBD);
    }
}
