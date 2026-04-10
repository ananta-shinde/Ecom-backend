package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.SpecificationRepository;

@Service
public class SpecificationService {
	
	@Autowired
	private SpecificationRepository specificationRepository;

}
