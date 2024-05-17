package com.fullStatckProject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fullStatckProject.Entity.Product;
import com.fullStatckProject.Repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepo;
	
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public Product insertProductIntoDatabase(Product product) {
		return productRepo.save(product);
	}
}
