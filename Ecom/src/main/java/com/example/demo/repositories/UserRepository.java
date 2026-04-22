package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository 
public interface UserRepository  extends JpaRepository<User,Long>{

	// For role_id = 1 (users)
    List<User> findByRoleId(Long roleId);
    User findByEmail(String email);
}
	