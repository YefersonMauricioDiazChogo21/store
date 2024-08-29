package com.store.store.producto.domain.service;

import java.util.List;

import com.store.store.producto.domain.entity.Producto;

public interface ProductoService {
    void addProducto(Producto producto);
    void deleteProducto(int id);
    List<Producto> findAllProductos();
}
