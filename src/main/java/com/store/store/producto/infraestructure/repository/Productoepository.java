package com.store.store.producto.infraestructure.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import org.json.JSONObject;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.store.store.producto.domain.entity.Producto;
import com.store.store.producto.domain.service.ProductoService;

public class Productoepository implements ProductoService{
    

    private static final String FILE_PATH = "productos.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void addProducto(Producto producto) {
        String id = String.valueOf(producto.getCodigo());
        ObjectNode productoNode = objectMapper.valueToTree(producto);

        // Leer el archivo JSON existente
        ObjectNode rootNode;
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                // Si el archivo existe, leer el contenido existente
                rootNode = (ObjectNode) objectMapper.readTree(file);
            } else {
                // Si el archivo no existe, crear un nuevo ObjectNode
                rootNode = objectMapper.createObjectNode();
            }

            // Añadir el nuevo producto al ObjectNode
            rootNode.set(id, productoNode);

            // Escribir el JSON actualizado al archivo
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, rootNode);
            System.out.println("Producto guardado en productos.json");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProducto(int id) {

            String idEli = String.valueOf(id);
            // Leer el archivo JSON existente
            ObjectNode rootNode;
            try {
                File file = new File(FILE_PATH);
                if (file.exists()) {
                    // Si el archivo existe, leer el contenido existente
                    rootNode = (ObjectNode) objectMapper.readTree(file);
    
                    // Verificar si el producto existe
                    if (rootNode.has(idEli)) {
                        // Eliminar el producto del ObjectNode
                        rootNode.remove(idEli);
    
                        // Escribir el JSON actualizado al archivo
                        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, rootNode);
                        System.out.println("Producto con código " + id + " eliminado de productos.json");
                    } else {
                        System.out.println("Producto con código " + id + " no encontrado.");
                    }
                } else {
                    System.out.println("El archivo productos.json no existe.");
                }
    
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Override
    public List<Producto> findAllProductos() {
        List<Producto> productos = new ArrayList<>();
         try {
            // Leer el archivo JSON
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            JSONObject jsonObject = new JSONObject(content);
            

            // Iterar sobre las claves
            for (String key : jsonObject.keySet()) {
                
                JSONObject product = jsonObject.getJSONObject(key);
                int codigo = product.getInt("codigo");
                String nombre = product.getString("nombre");
                int precio = product.getInt("precio");
                int stock = product.getInt("stock");
                Producto newProducto = new Producto(codigo,nombre,precio,stock);

                productos.add(newProducto);
                // // Imprimir los valores
                // System.out.println("Clave: " + key);
                // System.out.println("Código: " + codigo);
                // System.out.println("Nombre: " + nombre);
                // System.out.println("Precio: " + precio);
                // System.out.println("Stock: " + stock);
                // System.out.println();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return productos;
    }

}
