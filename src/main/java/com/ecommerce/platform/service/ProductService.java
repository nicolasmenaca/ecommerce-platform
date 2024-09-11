package com.ecommerce.platform.service;

import com.ecommerce.platform.model.Product;

public interface ProductService {
	
	Product createProduct(Product createProduct);
	Iterable<Product> listAllProducts();

	Product retrieveProductById(Long id);
}
