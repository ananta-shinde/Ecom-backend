package com.example.demo.controllers;

import com.example.demo.repositories.BrandRepository;
import com.example.demo.responses.AppResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.BrandDto;
import com.example.demo.entities.Brand;

import com.example.demo.entities.Category;
import com.example.demo.services.BrandService;

@RestController
public class BrandController {
	
	
	@Autowired
	private BrandService brandService;

	AppResponse appResponse ;
	
	public BrandController() {
		// TODO Auto-generated constructor stub
		appResponse = new AppResponse();
		}
	
	
	@PostMapping("/api/v1/brand/new")
	public AppResponse AddBrand(@ModelAttribute BrandDto brand) {
		Brand createdbrand = brandService.create(brand);
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
	
	@GetMapping("/api/v1/brand/{:id}")
	public Brand getBrandById(@PathVariable Long id) {
		return brandService.getById(id);
		
	}
	
	
	
}
