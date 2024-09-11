package com.ecommerce.platform;

import com.ecommerce.platform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommercePlatformAplicattion {


	@Autowired
	private static ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcommercePlatformAplicattion.class, args);
	}

}
