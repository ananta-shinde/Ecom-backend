package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.BrandDto;
import com.example.demo.entities.Brand;
import com.example.demo.repositories.BrandRepository;

@Service
public class BrandService {
	@Autowired
	  private BrandRepository brandRepository;
		
	  public Brand create(BrandDto brandDto) {
		  Brand brand = new Brand();
		  brand.setName(brandDto.getName());
		  brand.setDescription(brandDto.getDescription());
		  brand.setLogoUrl(brandDto.getLogoUrl());

		  return brandRepository.save(brand);
	  }
	  
//	  public void delete(Long id) {
//		  brandRepository.deleteById(id);
//	  }
	  
//	  public void delete(Brand brand) {
//		  brandRepository.delete(brand);
//	  }
	  
	  public void update(Brand brand) {
		  brandRepository.save(brand);
	  }
	  
	  public Brand getById(Long id) {
		  return brandRepository.getOne(id);
	  }
	  
	  
	  public List<Brand> getList(){
			// 👇 Change this so it only grabs brands where isDeleted == false
			return brandRepository.findByIsDeletedFalse();
		}
	  
	  public void delete(Long id) {
		  Brand brand = brandRepository.getById(id);
	  }
	  public void update(BrandDto brandDto) {
			// Find the existing brand
			Brand existingBrand = brandRepository.findById(brandDto.getId())
					.orElseThrow(() -> new RuntimeException("Brand not found"));

			// Update the name and description
			existingBrand.setName(brandDto.getName());
			existingBrand.setDescription(brandDto.getDescription());

			// Only update the logo if a new one was uploaded
			if (brandDto.getLogoUrl() != null && !brandDto.getLogoUrl().isEmpty()) {
				existingBrand.setLogoUrl(brandDto.getLogoUrl());
			}

			brandRepository.save(existingBrand);
		}
	// Add this inside BrandService.java
		public void softDelete(Long id) {
			Brand brand = brandRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Brand not found"));
			
			// This uses the exact setter from the entity you just shared!
			brand.setDeleted(true); 
			
			brandRepository.save(brand);
		}
	
}
