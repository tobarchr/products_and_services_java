package com.codingdojo.ct.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ct.models.Product;
import com.codingdojo.ct.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	public List<Product> findAllProducts(){
		return productRepository.findAll();
	}
	
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}
	
	public Product updateProduct(Product p) {
		return productRepository.save(p);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
