package com.store.store.producto.infraestructure.repository;

import java.io.IOException;
import java.util.List;
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.store.store.producto.domain.entity.Producto;
import com.store.store.producto.domain.service.ProductoService;

public class Productoepository implements ProductoService{
    

    @Override
    public void addProducto(Producto producto) {
        String id =String.valueOf(producto.getCodigo());
        producto.getNombre();
        producto.getPrecio();
        producto.getStock();
        
        ObjectMapper objectMapper = new ObjectMapper();
        // Crear un ObjectNode para representar el JSON
        ObjectNode rootNode = objectMapper.createObjectNode();

        // Convertir el objeto Producto a un ObjectNode
        ObjectNode productoNode = objectMapper.valueToTree(producto);

        // Añadir el producto al ObjectNode con el código como clave
        rootNode.set(id, productoNode);

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("productos.json"), rootNode);
            System.out.println("Producto guardado en productos.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProducto(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProducto'");
    }

    @Override
    public List<Producto> findAllProductos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllProductos'");
    }

}
