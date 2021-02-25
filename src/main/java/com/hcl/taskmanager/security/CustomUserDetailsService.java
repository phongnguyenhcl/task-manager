package com.hcl.taskmanager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hcl.taskmanager.entity.User;
import com.hcl.taskmanager.service.UserService;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserService UserService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = UserService.getSingleUser(username).get();
		if (user == null) {
			throw new UsernameNotFoundException("No matching user!");
		}
		return new CustomUserDetails(user);
	}

}
