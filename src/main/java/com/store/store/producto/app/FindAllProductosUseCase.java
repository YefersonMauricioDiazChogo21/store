package com.store.store.producto.app;

import java.util.List;

import com.store.store.producto.domain.entity.Producto;
import com.store.store.producto.domain.service.ProductoService;

public class FindAllProductosUseCase {
     private ProductoService productoService;

    public FindAllProductosUseCase(ProductoService productoService){
        this.productoService = productoService;
    }

    public List<Producto> execute(){
        return productoService.findAllProductos();
    }
}
