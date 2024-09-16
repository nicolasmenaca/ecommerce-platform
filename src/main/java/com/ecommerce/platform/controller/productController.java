package com.ecommerce.platform.controller;

import com.ecommerce.platform.DTO.ProductDto;
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
	
	@GetMapping("/list ")
	public ResponseEntity<Iterable<Product>> listAllProducts() {
		return ResponseEntity.ok(productService.listAllProducts());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
		Product product = new Product();
		product.setName(productDto.getName());
		product.setCost(productDto.getCost());
		product.setDetails(productDto.getDetails());
		product.setImageUrl(productDto.getImageUrl());
		product.setStock(productDto.getStock());

		Product createdProduct =productService.createProduct(product);
		return ResponseEntity.ok(createdProduct);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> retrieveProductById(@PathVariable Long id) {
		Product product = productService.retrieveProductById(id);
		if (product != null){
			return ResponseEntity.ok(product);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}


