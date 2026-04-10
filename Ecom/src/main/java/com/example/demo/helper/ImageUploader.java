package com.example.demo.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dtos.DTO;
import com.example.demo.dtos.ProductDTO;

@Component
public class ImageUploader {

	@Value("${app.upload.dir}")
	private  String uploadDir;
	@Value("${app.baseUrl}")
	private String baseUrl;
	
	public ProductDTO uploadImage(DTO productDTO) {
		Path copyLocation = Paths.get(uploadDir);
		List<MultipartFile> fileList = productDTO.getImage();
		MultipartFile thumbnail = productDTO.getThumbnailImage();
		try {
			List<String> images = new ArrayList<String>();
			// upaloding product Images
			for(MultipartFile file:fileList) {
				Files.createDirectories(copyLocation);
				String fileName = UUID.randomUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
				Files.copy(file.getInputStream(), copyLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
				images.add(baseUrl+fileName);
			}
			productDTO.setImages(images);
			
			// upload product thumbnail
			Files.createDirectories(copyLocation);
			String fileName = UUID.randomUUID() + thumbnail.getOriginalFilename().substring(thumbnail.getOriginalFilename().lastIndexOf("."));
			Files.copy(thumbnail.getInputStream(), copyLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
			productDTO.setThumbnail(baseUrl+fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productDTO;
				
	}
	
}
