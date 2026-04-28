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

@Component
public class BrandImageUploader {

	@Value("${app.brand.upload.dir}")
	private  String uploadDir;
	@Value("${app.baseUrl}")
	private String baseUrl;
	
	public List<String> uploadImage(List<MultipartFile> files) throws IOException {
		Path copyLocation = Paths.get(uploadDir);
		List<String> images = new ArrayList<String>();
		for(MultipartFile file:files) {
			Files.createDirectories(copyLocation);
			String fileName = UUID.randomUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			Files.copy(file.getInputStream(), copyLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
			images.add(baseUrl+"brands/"+fileName);
		}	
		return images;
	}
	
	public String uploadImage(MultipartFile file) throws IOException {
		Path copyLocation = Paths.get(uploadDir);
			Files.createDirectories(copyLocation);
			String fileName = UUID.randomUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			Files.copy(file.getInputStream(), copyLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
			return baseUrl+"brands/"+fileName;
			
		
	}
}
