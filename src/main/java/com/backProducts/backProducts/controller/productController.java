package com.backProducts.backProducts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backProducts.backProducts.model.Product;
import com.backProducts.backProducts.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins ="http://localhost:4200")
public class productController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public Iterable<Product> getAllProducts() {
		Iterable<Product> products = productService.getAllProducts();
		System.out.println("Productos recuperados del servicio: " + products);
		return products;
	}
	
	@PostMapping("/newproduct")
	public Product newProduct(@RequestBody Product newProduct) {
		try {
	        return this.productService.newProduct(newProduct);
		} catch (Exception e) {
	        System.err.println("Error al procesar la solicitud: " + e.getMessage());
	        e.printStackTrace();
	        throw e; // Re-lanzamos la excepción para que Spring la maneje
		}
	}
	
	//falta crear el metodo de crear un producto
	
	/*@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
		Product product = productService.getProductById(id);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/
}
