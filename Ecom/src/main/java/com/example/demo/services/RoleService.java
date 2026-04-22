package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.BrandDto;
import com.example.demo.entities.Brand;
import com.example.demo.entities.Role;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role create(Role role) {
		 return roleRepository.save(role);
	}
	
	public Role update(Role role) {
		 return roleRepository.save(role);
	}
	
	public void delete(Long id) {
		 roleRepository.deleteById(id);
	}
	
	public Role getById(Long id) {
		 return roleRepository.getById(id);
	}
	
	public List<Role> getList() {
		 return roleRepository.findAll();
	}
}
