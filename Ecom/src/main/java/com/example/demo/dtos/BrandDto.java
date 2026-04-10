package com.example.demo.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BrandDto extends DTO{
	
	private String name;
	private String description;
	private List<MultipartFile> image;
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
	public List<MultipartFile> getImage() {
		return image;
	}
	public void setImage(List<MultipartFile> logo) {
		this.image= logo;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	
	

}
