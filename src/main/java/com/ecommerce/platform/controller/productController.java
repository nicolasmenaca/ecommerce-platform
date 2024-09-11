package com.ecommerce.platform.controller;

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

import com.ecommerce.platform.model.Product;
import com.ecommerce.platform.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins ="http://localhost:4200")
public class productController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public Iterable<Product> listAllProducts() {
		Iterable<Product> products = productService.listAllProducts();
		System.out.println("Productos recuperados del servicio: " + products);
		return products;
	}
	
	@PostMapping("/newproduct")
	public Product createProduct(@RequestBody Product product) {
		try {
	        return this.productService.createProduct(product);
		} catch (Exception e) {
	        System.err.println("Error al procesar la solicitud: " + e.getMessage());
	        e.printStackTrace();
	        throw e;
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> retrieveProductById(@PathVariable("id") Long id) {
		try {
			Product product = productService.retrieveProductById(id);
			if (product != null) {
				return new ResponseEntity<>(product, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.err.println("Error al procesar la solicitud: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}


