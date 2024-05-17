package com.fullStatckProject.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullStatckProject.Entity.Product;
import com.fullStatckProject.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@GetMapping("/all")
	public List<Product> gettAllProducts() {
		return productService.getAllProducts();
	}
	
	
	@PostMapping("/insert")
	public Product insertProductIntoDatabase(@RequestBody Product product) {
		return productService.insertProductIntoDatabase(product);
	}
}
