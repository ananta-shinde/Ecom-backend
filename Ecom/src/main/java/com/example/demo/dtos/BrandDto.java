package com.example.demo.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BrandDto{
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String name;
	private String description;
	private MultipartFile image;
	private String logoUrl;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setImage(MultipartFile logo) {
		this.image= logo;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public MultipartFile getImage() {
		return image;
	}
	
	

}
