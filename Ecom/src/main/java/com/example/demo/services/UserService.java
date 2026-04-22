package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Profile;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.CartRepository;
import com.example.demo.repositories.ProfileRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProfileRepository profileRepository;
	
	public User create(User user) {
		Cart cart = new Cart();
		Profile profile = new Profile();
		cart = cartRepository.save(cart);
		user.setCart(cart);
		profile = profileRepository.save(profile);
		user.setProfile(profile);
		return userRepository.save(user);
	}
	
	public User update(User user) {
		return userRepository.save(user);
	}
	
	public User getById(Long id) {
		return userRepository.getById(id);
	}
	
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public List<User> getByRoleId(Long roleId) {
		return userRepository.findByRoleId(roleId);
	}
	
	public List<User> getAllList() {
		return userRepository.findAll();
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
