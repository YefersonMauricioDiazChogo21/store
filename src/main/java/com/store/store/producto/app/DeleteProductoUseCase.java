package com.store.store.producto.app;

import com.store.store.producto.domain.service.ProductoService;

public class DeleteProductoUseCase {
    private ProductoService productoService;

    public DeleteProductoUseCase(ProductoService productoService){
        this.productoService = productoService;
    }

    public void execute(int id){
        productoService.deleteProducto(id);
    }
}
