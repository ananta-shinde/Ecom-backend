package com.example.demo.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO  {
	
	private String name;
	private String description;
	private Long brandId;
	private double price;
	private Long categoryId;
	private List<MultipartFile> images;
	private List<String> imageUrls;
	private MultipartFile thumbnailimage;
	private String thumbnail;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public MultipartFile getThumbnailimage() {
		return thumbnailimage;
	}

	public void setThumbnailimage(MultipartFile thumbnailimage) {
		this.thumbnailimage = thumbnailimage;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
	
	
	
	

}
