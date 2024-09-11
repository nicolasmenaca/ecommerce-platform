package com.backProducts.backProducts;

import com.backProducts.backProducts.model.Product;
import com.backProducts.backProducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackProductsApplication {


	@Autowired
	private static ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackProductsApplication.class, args);
	}

}
