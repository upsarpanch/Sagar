package com.sagar.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.cloud.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);

}
