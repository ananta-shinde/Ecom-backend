package com.example.demo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Brand;
import com.example.demo.entities.Product;
import com.example.demo.helper.ProductImageUploader;
import com.example.demo.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductImageUploader uploader;
	
	@PostMapping("/api/v1/product/new")
	public String AddProduct(@ModelAttribute ProductDTO productDto ) {
		try {
			productDto.setImageUrls( uploader.uploadImage(productDto.getImages()));
			productDto.setThumbnail(uploader.uploadImage(productDto.getThumbnailimage()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productService.create(productDto);
		return "product added";
	}
	
	@GetMapping("/api/v1/product")
	public List<Product> getBrands() {
		return productService.getproducts();
		
	}
	
	@GetMapping("/api/v1/product/{:id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.getproductById(id);
		
	}
	
//	@PostMapping("/api/v1/product/file")
//	public String getProduct(@ModelAttribute ProductDTO productDto) {
//		return ImageUploader.uploadImage(productDto.getProductImage());
//		
//	}
	
	
	

}
