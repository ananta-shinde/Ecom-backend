package com.example.demo.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.BrandDto;
import com.example.demo.entities.Brand;
import com.example.demo.entities.Category;
import com.example.demo.entities.Role;
import com.example.demo.responses.AppResponse;
import com.example.demo.services.RoleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RoleController {

	@Autowired
	RoleService roleService;
	
	AppResponse appResponse;
	
	public RoleController(AppResponse appResponse) {
		// TODO Auto-generated constructor stub
		this.appResponse = appResponse;
	}
	
	@PostMapping("/api/v1/role/new")
	public AppResponse AddRole(@RequestBody Role role) {
		Role createdrole = roleService.create(role);
		appResponse.put("status", 201);
		appResponse.put("id", createdrole.getId());
		appResponse.put("message", "role created successfully");
		return appResponse;
	}
	
	@GetMapping("/api/v1/role")
	public AppResponse getRoles() {
		appResponse.put("roles", roleService.getList());
		appResponse.put("status", 200);
		return appResponse;	
	}
	
	@GetMapping("/api/v1/role/{id}")
	public AppResponse getRole(@PathVariable Long id) {
		Role role = roleService.getById(id);
		if(role != null) {
		appResponse.put("status", 200);
		appResponse.put("message", "success");
		appResponse.put("role", role);
		}else {
			appResponse.put("status", 404);
			appResponse.put("message", "not found");
			
		}
		return appResponse;
		
	}
	
	@PutMapping("/api/v1/role/update")
	public AppResponse updateRole(@RequestBody Role role) {
		Role role2 = roleService.update(role);
		appResponse.put("status", 200);
		appResponse.put("message", "success");
		appResponse.put("role", role2);
		return appResponse;
		
	}
	
	@DeleteMapping("/api/v1/role/delete/{id}")
	public AppResponse deleteRole(@PathVariable Long id) {
		roleService.delete(id);
		appResponse.put("status", 200);
		appResponse.put("message", "successfully deleted");
		return appResponse;
	}
}
