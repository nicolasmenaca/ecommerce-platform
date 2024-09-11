package com.backProducts.backProducts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backProducts.backProducts.model.Product;
import com.backProducts.backProducts.repository.ProductRepository;

@Service
public class ProductServiceImplement implements ProductService {
	
	@Autowired
    private ProductRepository productRepository; // Inyección del servicio

	@Override
    public Iterable<Product> getAllProducts() {
        // Lógica para obtener todos los productos
		Iterable<Product> products = this.productRepository.findAll();
	    System.out.println("Productos recuperados del repositorio: " + products);
        return products;
    }
	
    @Override
    public Product newProduct(Product newProduct) {
        // Lógica para agregar un nuevo producto
    	try {
    		return productRepository.save(newProduct);
    	} catch (Exception e) {
    		e.printStackTrace(); // Imprime la traza de la excepción en la consola
            throw new RuntimeException("Error al guardar el nuevo producto en la base de datos");
    	}
    }
}
