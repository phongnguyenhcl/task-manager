package com.hcl.taskmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.taskmanager.entity.User;

@Repository
public interface  UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
