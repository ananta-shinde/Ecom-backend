package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

@RestController
public class CategoryController {
	
	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping("/api/v1/category/new")
	public String AddCategory(@RequestBody Category category) {
		categoryService.createNewCategory(category);
		return "category added";
	}
	
	@GetMapping("/api/v1/category")
	public List<Category> getCategory() {
		return categoryService.getCategoryList();
		
	}
	
	@GetMapping("/api/v1/category/{id}")
	public Category AddCategory(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
		
	}
	
	@DeleteMapping("/api/v1/category/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return "category deleted";
		
	}
	
	@PutMapping("/api/v1/category/update")
	public String updateCategory(@RequestBody Category category) {
		categoryService.updateCategory(category);
		return "category updated";
		
	}
}
