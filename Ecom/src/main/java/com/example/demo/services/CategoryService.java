package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	  @Autowired
	  private CategoryRepository cateogoryRepository;
		
	  public Category createNewCategory(Category category) {
		  return cateogoryRepository.save(category);
	  }
	  
	  public void deleteCategory(Long id) {
		  cateogoryRepository.deleteById(id);
	  }
	  
	  public void deleteCategory(Category category) {
		  cateogoryRepository.delete(category);
	  }
	  
	  public Category updateCategory(Category category) {
		  return cateogoryRepository.save(category);
	  }
	  
	  public Category getCategoryById(Long id) {
		  return cateogoryRepository.getOne(id);
	  }
	  
	  public List<Category> getCategoryList(){
		  return cateogoryRepository.findAll();
	  }
	  
	  public Category getCategoryByName(String name) {
		  return cateogoryRepository.findByName(name);
	  }
	  
	  public boolean isExist(String name) {
		Category cat =cateogoryRepository.findByName(name);
		if(cat == null) {
			return false;
		}else {
			return true;
		}
	  }
}
