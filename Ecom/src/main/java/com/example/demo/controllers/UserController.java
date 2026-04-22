package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.responses.AppResponse;
import com.example.demo.services.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	AppResponse appResponse;
	
	public UserController(AppResponse appResponse) {
		// TODO Auto-generated constructor stub
		this.appResponse = appResponse;
	}
	
	@PostMapping("api/v1/user/new")
	public AppResponse creatUser(@RequestBody User user) {
		User createduser = userService.create(user);
		appResponse.put("status", 201);
		appResponse.put("id", createduser.getId());
		appResponse.put("message", "user created successfully");
		
		return appResponse;
	}
	
	@PutMapping("/api/v1/user/update")
	public AppResponse updateUser(@RequestBody User user) {
		User updatedUser = userService.update(user);
		appResponse.put("status", 200);
		appResponse.put("message", "success");
		appResponse.put("user", updatedUser);
		return appResponse;
		
	}
	
	@GetMapping("/api/v1/user")
	public AppResponse getAllUsers() {
		appResponse.put("users", userService.getAllList());
		appResponse.put("status", 200);
		return appResponse;	
	}
	
	@GetMapping("/api/v1/user/customers")
	public AppResponse getCustomers() {
		appResponse.put("customers", userService.getByRoleId(1L));
		appResponse.put("status", 200);
		return appResponse;	
	}
	
	@GetMapping("/api/v1/user/sellers")
	public AppResponse getSellers() {
		appResponse.put("sellers", userService.getByRoleId(2L));
		appResponse.put("status", 200);
		return appResponse;	
	}
	
	@GetMapping("/api/v1/user/{id}")
	public AppResponse getUser(@PathVariable Long id) {
		User user = userService.getById(id);
		if(user != null) {
		appResponse.put("status", 200);
		appResponse.put("message", "success");
		appResponse.put("user", user);
		}else {
			appResponse.put("status", 404);
			appResponse.put("message", "not found");
			
		}
		return appResponse;
		
	}
	
	@PostMapping("/api/v1/auth/login")
	public AppResponse login(@RequestBody User user) {

	    User existingUser = userService.getByEmail(user.getEmail());

	    if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
	        appResponse.put("status", 200);
	        appResponse.put("message", "Login successful");
	        appResponse.put("user", existingUser);
	    } else {
	        appResponse.put("status", 401);
	        appResponse.put("message", "Invalid email or password");
	    }

	    return appResponse;
	}
	
	@DeleteMapping("/api/v1/user/delete/{id}")
	public AppResponse deleteUser(@PathVariable Long id) {
		userService.delete(id);
		appResponse.put("status", 200);
		appResponse.put("message", "successfully deleted");
		return appResponse;
	}
	
}
