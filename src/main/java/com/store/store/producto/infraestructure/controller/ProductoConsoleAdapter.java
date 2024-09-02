package com.store.store.producto.infraestructure.controller;

import com.store.store.producto.domain.service.ProductoService;
import com.store.store.producto.infraestructure.repository.Productoepository;
import com.store.store.producto.domain.entity.Producto;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.store.store.producto.app.AddProductoUseCase;
import com.store.store.producto.app.DeleteProductoUseCase;
import com.store.store.producto.app.FindAllProductosUseCase;

public class ProductoConsoleAdapter {
    private ProductoService productoService;
    private AddProductoUseCase addProducto;
    private FindAllProductosUseCase allProductos;
    private DeleteProductoUseCase deleteProducto;
    Scanner scanner = new Scanner(System.in);

    public ProductoConsoleAdapter(){
        this.productoService = new Productoepository();
        this.addProducto = new AddProductoUseCase(productoService);
        this.allProductos = new FindAllProductosUseCase(productoService);
        this.deleteProducto = new DeleteProductoUseCase(productoService);
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
            case 2:
                List<Producto> product = allProductos.execute();
                String productos= "";
                for (Producto pro : product){
                    int cod = pro.getCodigo();
                    String name = pro.getNombre();
                    int price = pro.getPrecio();
                    int stockA = pro.getStock();
                    String prod = "Codigo: " + cod + " Nombre: " + name + " Precio: " + price + " Stock: " + stockA + "\n";
                    productos = productos + prod;
                }
                System.out.println(productos);
                start();
                break;
            case 3:
                try {
                    System.out.println("Ingrese el id del capitulo para eliminar: ");
                    int idaeliminar = scanner.nextInt();
                    deleteProducto.execute(idaeliminar);
                    start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                    start();
                }
                break;
            default:
                break;
        }
    }
    
}
