package com.netec.GestionProductos.service;

import com.netec.GestionProductos.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductosService {
    Producto save(Producto producto);
    List<Producto> list();
    Optional<Producto> listById(Integer id);
}
