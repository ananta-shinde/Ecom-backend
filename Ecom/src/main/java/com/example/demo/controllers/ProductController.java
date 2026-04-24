package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.helper.ProductImageUploader;
import com.example.demo.responses.AppResponse;
import com.example.demo.services.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductImageUploader uploader;
	@Autowired
	private AppResponse appResponse;
	
	@PostMapping("/api/v1/product/new")
	public String AddProduct(@ModelAttribute ProductDTO productDto ) {
		try {
			// 1. Only upload multiple images if the list is NOT null and NOT empty
			if (productDto.getImages() != null && !productDto.getImages().isEmpty()) {
				productDto.setImageUrls(uploader.uploadImage(productDto.getImages()));
			}
			
			// 2. Only upload the thumbnail if it is NOT null and NOT empty
			if (productDto.getThumbnailimage() != null && !productDto.getThumbnailimage().isEmpty()) {
				productDto.setThumbnail(uploader.uploadImage(productDto.getThumbnailimage()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		productService.create(productDto);
		return "product added";
	}
	
	@GetMapping("/api/v1/product")
	public List<Product> getProducts() { 
		return productService.getproducts();
	}
	
	
	@GetMapping("/api/v1/product/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.getproductById(id);
	}
	
	
	@DeleteMapping("/api/v1/product/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.softDelete(id); 
		
		return "product deleted";
	}
	@PostMapping("/api/v1/product/update")
	public String updateProduct(@ModelAttribute ProductDTO productDto ) {
		try {
			// Only upload new images if the user actually selected them
			if (productDto.getImages() != null && !productDto.getImages().isEmpty() && productDto.getImages().get(0).getSize() > 0) {
				productDto.setImageUrls(uploader.uploadImage(productDto.getImages()));
			}
			
			// Only upload a new thumbnail if the user actually selected one
			if (productDto.getThumbnailimage() != null && !productDto.getThumbnailimage().isEmpty()) {
				productDto.setThumbnail(uploader.uploadImage(productDto.getThumbnailimage()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		productService.update(productDto); 
		
		return "product updated";
	}
	@PostMapping("/api/v1/product/featured/update")
	public String updateFeaturedProducts(@RequestBody List<Long> featuredIds) {
		productService.updateFeaturedProducts(featuredIds);
		return "Featured products updated successfully";
	}
	@GetMapping("/api/v1/product/featured")
	public AppResponse getFeaturedProducts() {
		try {
			List<Product> featured = productService.getFeaturedProducts();
            
			appResponse.put("status", 200);
			appResponse.put("message", "success");
			appResponse.put("products", featured); 
		} catch (Exception e) {
			appResponse.put("status", 500);
			appResponse.put("message", "Failed to fetch featured products");
		}
		return appResponse;
	}
	@GetMapping("/api/v2/product/{category}")
	public AppResponse getProductByCategory(@PathVariable String category) {
		List<Product> products= productService.getProductByCategory(category);
		appResponse.put("status", 200);
		appResponse.put("message", "success");
		appResponse.put("products", products); 
		return appResponse;
	}
}