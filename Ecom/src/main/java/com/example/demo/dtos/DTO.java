package com.example.demo.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public abstract class DTO {
	public List<MultipartFile> image = null;
	public  MultipartFile thumbnailImage = null;
	
	
	public abstract List<MultipartFile> getImage();
	public abstract void setImage(List<MultipartFile> image);
	public void setThumbnailImage(MultipartFile thumbnailImage) {
		
	}
	public MultipartFile getThumbnailImage() {
		return null;
	}
	
}
