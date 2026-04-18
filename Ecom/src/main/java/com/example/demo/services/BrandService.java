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
		  return brandRepository.findAll();
	  }
	  
	  public void delete(Long id) {
		  Brand brand = brandRepository.getById(id);
	  }
	  
	  
	
}
