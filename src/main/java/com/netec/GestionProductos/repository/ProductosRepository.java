package com.netec.GestionProductos.repository;

import com.netec.GestionProductos.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository <Producto, Integer> {

}
