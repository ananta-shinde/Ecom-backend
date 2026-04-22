package com.example.demo.controllers;

import com.example.demo.helper.BrandImageUploader;

import com.example.demo.repositories.BrandRepository;
import com.example.demo.responses.AppResponse;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping; // Put this at the top with other imports!

import com.example.demo.dtos.BrandDto;
import com.example.demo.entities.Brand;

import com.example.demo.entities.Category;
import com.example.demo.services.BrandService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BrandController {
	
	@Autowired
	private  BrandImageUploader imageUploader;

	@Autowired
	private BrandService brandService;

	@Autowired
	AppResponse appResponse ;
	
	
	
	
	@PostMapping("/api/v1/brand/new")
	public AppResponse AddBrand(@ModelAttribute BrandDto brandDto) {
		try {
			if(brandDto.getImage() != null) {
				brandDto.setLogoUrl(imageUploader.uploadImage(brandDto.getImage()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			appResponse.put("status",500);
			appResponse.put("message", "somthing went wrong try again");
			return appResponse;
		}
		Brand createdbrand = brandService.create(brandDto);
		appResponse.put("status", 201);
		appResponse.put("id", createdbrand.getId());
		appResponse.put("message", "brand created successfully");
		return appResponse;
	}
	
	@GetMapping("/api/v1/brand")
	public AppResponse getBrands() {
		appResponse.put("brands", brandService.getList());
		appResponse.put("status", 200);
		return appResponse;	
	}
	
	@GetMapping("/api/v1/brand/{id}")
	public AppResponse getBrandById(@PathVariable Long id) {
				Brand brand = brandService.getById(id);
				if(brand != null) {
					appResponse.put("status", 200);
					appResponse.put("message", "success");
					appResponse.put("brand", brand);
					}else {
						appResponse.put("status", 404);
						appResponse.put("message", "not found");
						
					}
				return appResponse;

	}
	@PostMapping("/api/v1/brand/update")
	public AppResponse updateBrand(@ModelAttribute BrandDto brandDto) {
		
		try {
			// Fixed: Changed getLogo() to getImage() to match your DTO
			if (brandDto.getImage() != null && !brandDto.getImage().isEmpty()) {
				brandDto.setLogoUrl(imageUploader.uploadImage(brandDto.getImage()));
			}
		} catch (IOException e) {
			e.printStackTrace();
			appResponse.put("status", 500);
			appResponse.put("message", "Error uploading image");
			return appResponse;
		}
		
		// Call your BrandService to save the updated data
		brandService.update(brandDto); 
		
		appResponse.put("status", 200);
		appResponse.put("message", "brand updated successfully!");
		return appResponse;
	}
	

	// Add this inside BrandController.java
	@DeleteMapping("/api/v1/brand/{id}")
	public AppResponse deleteBrand(@PathVariable Long id) {
		try {
			brandService.softDelete(id);
			
			appResponse.put("status", 200);
			appResponse.put("message", "Brand deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			appResponse.put("status", 500);
			appResponse.put("message", "Failed to delete brand");
		}
		return appResponse;
	}
}
