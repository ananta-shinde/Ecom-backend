package com.example.demo.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
	
	private String name;
	private String description;
	private Long brandId;
	private Long categoryId;
	private List<MultipartFile> productImage;
	private MultipartFile thumbnailImage;
	private List<String> images;
	private String thumbnail;
	
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
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public List<MultipartFile> getProductImage() {
		return productImage;
	}
	public void setProductImage(List<MultipartFile> productImage) {
		this.productImage = productImage;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public MultipartFile getThumbnailImage() {
		return thumbnailImage;
	}
	public void setThumbnailImage(MultipartFile thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
	
	
	

}
