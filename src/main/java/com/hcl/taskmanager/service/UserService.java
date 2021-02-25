package com.hcl.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.taskmanager.entity.User;
import com.hcl.taskmanager.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	PasswordEncoder passwordencoder;
	
	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public Optional<User> getSingleUser(String username) {
		return userRepo.findByUsername(username);
	}
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public void saveUser(User user) {
		String encodedPassword = passwordencoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
	}
	
	
	
}
