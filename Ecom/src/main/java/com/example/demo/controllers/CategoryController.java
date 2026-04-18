package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.responses.AppResponse;
import com.example.demo.services.CategoryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AppResponse appResponse;
	
	

	@PostMapping("/api/v1/category/new")
	public AppResponse AddCategory(@RequestBody Category category) {
		Category createdCatgory =categoryService.createNewCategory(category);
		appResponse.put("status", 201);
		appResponse.put("message", "category created successfully");
		appResponse.put("id", createdCatgory.getId());
		return appResponse;
	}
	
	@GetMapping("/api/v1/category")
	public AppResponse getCategory() {
		List<Category> categories =categoryService.getCategoryList();
		appResponse.put("status", 200);
		appResponse.put("message", "category list");
		appResponse.put("categories", categories);
		return appResponse;
		
	}
	
	@GetMapping("/api/v1/category/{id}")
	public AppResponse AddCategory(@PathVariable Long id) {
		Category category = categoryService.getCategoryById(id);
		if(category != null) {
		appResponse.put("status", 200);
		appResponse.put("message", "success");
		appResponse.put("category", category);
		}else {
			appResponse.put("status", 404);
			appResponse.put("message", "not found");
			
		}
		return appResponse;
		
	}
	
	@DeleteMapping("/api/v1/category/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return "category deleted";
		
	}
	
	@PutMapping("/api/v1/category/update")
	public AppResponse updateCategory(@RequestBody Category category) {
		Category cat=categoryService.updateCategory(category);
		appResponse.put("status", 200);
		appResponse.put("message", "success");
		appResponse.put("category", cat);
		return appResponse;
		
	}
}
