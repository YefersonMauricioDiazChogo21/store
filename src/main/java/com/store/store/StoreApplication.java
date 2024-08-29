package com.store.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.store.store.producto.infraestructure.controller.ProductoConsoleAdapter;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
		ProductoConsoleAdapter pca = new ProductoConsoleAdapter();
		pca.start();
	}

}
