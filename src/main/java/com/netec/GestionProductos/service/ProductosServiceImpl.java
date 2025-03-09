package com.netec.GestionProductos.service;

import com.netec.GestionProductos.entities.Producto;
import com.netec.GestionProductos.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosServiceImpl implements ProductosService{
    @Autowired
    ProductosRepository productosRepository;

    @Override
    public Producto save(Producto producto) {
        return productosRepository.save(producto);
    }
}
