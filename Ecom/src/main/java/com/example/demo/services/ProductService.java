package com.example.demo.services;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.repositories.BrandRepository;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	public void  create(ProductDTO productDto) {
		Product newProduct = new Product();
		newProduct.setName(productDto.getName());
		newProduct.setDescription(productDto.getDescription());
		newProduct.setBrand(brandRepository.getById(productDto.getBrandId()));
		newProduct.setCategory(categoryRepository.getById(productDto.getCategoryId()));
		newProduct.setImages(productDto.getImageUrls());
		newProduct.setThumbnailImage(productDto.getThumbnail());
		newProduct.setPrice(productDto.getPrice());
		productRepository.save(newProduct);
	}
	
	public void update(ProductDTO productDto) {
		// 1. Find the existing product in the database using the ID sent from React
		Product existingProduct = productRepository.findById(productDto.getId())
				.orElseThrow(() -> new RuntimeException("Product not found"));

		// 2. Update the text fields
		existingProduct.setName(productDto.getName());
		existingProduct.setDescription(productDto.getDescription());
		existingProduct.setPrice(productDto.getPrice());

		// 3. Update the relationships (Brand & Category)
		existingProduct.setBrand(brandRepository.findById(productDto.getBrandId()).orElse(null));
		existingProduct.setCategory(categoryRepository.findById(productDto.getCategoryId()).orElse(null));

		// 4. Update Images ONLY IF new ones were uploaded
		if (productDto.getThumbnail() != null && !productDto.getThumbnail().isEmpty()) {
			existingProduct.setThumbnailImage(productDto.getThumbnail());
		}
		
		if (productDto.getImageUrls() != null && !productDto.getImageUrls().isEmpty()) {
			existingProduct.setImages(productDto.getImageUrls());
		}
		productRepository.save(existingProduct);
	}
	
	public void  delete(Long id) {
		productRepository.deleteById(id);
	}
	
	public List<Product>  getproducts() {
		return productRepository.findAll();
	}
	
	public Product  getproductById(Long id) {
		return productRepository.getById(id);
	}
	public void softDelete(Long id) {
	    Product product = productRepository.findById(id).orElseThrow();
	    product.setDeleted(true);
	    productRepository.save(product);
	}
	
	
	public List<Product> getFeaturedProducts() {
		return productRepository.findByIsFeaturedTrueAndIsDeletedFalse();
	}

	@Transactional
	public void updateFeaturedProducts(List<Long> featuredIds) {
		List<Product> allProducts = productRepository.findAll();
		allProducts.forEach(p -> p.setFeatured(false));
		
		if (featuredIds != null && !featuredIds.isEmpty()) {
			List<Product> featuredOnes = productRepository.findAllById(featuredIds);
			featuredOnes.forEach(p -> p.setFeatured(true));
		}
		
		productRepository.saveAll(allProducts);
	}
	
	public List<Product> getProductByCategory(String name) {
		return productRepository.findByCategoryName(name);
		
	}
}
