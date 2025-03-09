package com.netec.GestionProductos.service;

import com.netec.GestionProductos.entities.Producto;

import java.util.List;

public interface ProductosService {
    Producto save(Producto producto);
    List<Producto> list();
}
