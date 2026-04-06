package com.example.demo.controllers;

import com.example.demo.repositories.BrandRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Brand;
import com.example.demo.entities.Category;
import com.example.demo.services.BrandService;

@RestController
public class BrandController {
	
	
	@Autowired
	private BrandService brandService;

	
	
	@PostMapping("/api/v1/brand/new")
	public String AddBrand(@RequestBody Brand brand) {
		brandService.create(brand);
		return "brand added";
	}
	
	@GetMapping("/api/v1/brand")
	public List<Brand> getBrands() {
		return brandService.getList();
		
	}
	
	@GetMapping("/api/v1/brand/{:id}")
	public Brand getBrands(@PathVariable Long id) {
		return brandService.getById(id);
		
	}
	
	
	
}
