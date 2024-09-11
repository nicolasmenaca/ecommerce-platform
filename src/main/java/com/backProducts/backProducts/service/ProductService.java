package com.backProducts.backProducts.service;

import com.backProducts.backProducts.model.Product;

public interface ProductService {
	
	Product newProduct(Product newProduct);
	Iterable<Product> getAllProducts();

	Product getProductById(Long id);
}
