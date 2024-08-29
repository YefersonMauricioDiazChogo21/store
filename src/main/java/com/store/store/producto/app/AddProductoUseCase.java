package com.store.store.producto.app;

import com.store.store.producto.domain.entity.Producto;
import com.store.store.producto.domain.service.ProductoService;

public class AddProductoUseCase {
    private ProductoService productoService;

    public AddProductoUseCase(ProductoService productoService){
        this.productoService = productoService;
    }

    public void execute(Producto producto){
        productoService.addProducto(producto);
    }
}
