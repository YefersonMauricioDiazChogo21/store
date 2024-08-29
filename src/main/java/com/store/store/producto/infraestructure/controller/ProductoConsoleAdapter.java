package com.store.store.producto.infraestructure.controller;

import com.store.store.producto.domain.service.ProductoService;
import com.store.store.producto.infraestructure.repository.Productoepository;
import com.store.store.producto.domain.entity.Producto;

import java.util.Scanner;

import com.store.store.producto.app.AddProductoUseCase;

public class ProductoConsoleAdapter {
    private ProductoService productoService;
    private AddProductoUseCase addProducto;
    Scanner scanner = new Scanner(System.in);

    public ProductoConsoleAdapter(){
        this.productoService = new Productoepository();
        this.addProducto = new AddProductoUseCase(productoService);
        start();
    }

    public void start(){
        System.out.println("Presiones 1 para agregar");
        int opcion=scanner.nextInt();
    
        ejecutar(opcion);
    }

    public void ejecutar(int opcion){

        switch (opcion) {
            case 1:
                System.out.println("Ingrese el codigo");
                int codigo = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Ingrese el Nombre");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese el precio");
                int precio = scanner.nextInt();
                System.out.println("Ingrese el stock");
                int stock = scanner.nextInt();
                Producto producto = new Producto(codigo,nombre,precio,stock);
                addProducto.execute(producto);
                start();
                break;
        
            default:
                break;
        }
    }
    
}
