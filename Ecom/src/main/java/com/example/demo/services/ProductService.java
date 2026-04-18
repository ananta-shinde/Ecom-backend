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
		productRepository.save(newProduct);
	}
	
	public void  update(Product product) {
		productRepository.save(product);
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
	
	
	
	
	
}
