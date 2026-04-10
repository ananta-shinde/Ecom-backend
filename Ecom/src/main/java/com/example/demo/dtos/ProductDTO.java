package com.example.demo.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO extends DTO {
	
	private String name;
	private String description;
	private Long brandId;
	private Long categoryId;
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

	public List<MultipartFile> getImage() {
		return image;
	}
	public void setImage(List<MultipartFile> image) {
		image = image;
	}
//	public MultipartFile getThumbnailImage() {
//		return thumbnailImage;
//	}
//	public void setThumbnailImage(MultipartFile thumbnailImage) {
//		this.thumbnailImage = thumbnailImage;
//	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	@Override
	public void setThumbnailImage(MultipartFile thumbnailImage) {
		// TODO Auto-generated method stub
		this.thumbnailImage = thumbnailImage;
	}
	@Override
	public MultipartFile getThumbnailImage() {
		// TODO Auto-generated method stub
		return thumbnailImage;
	}
	
	
	

}
