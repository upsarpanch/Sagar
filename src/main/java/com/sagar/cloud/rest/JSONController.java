package com.sagar.cloud.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.cloud.model.Product;
import com.sagar.cloud.model.User;
import com.sagar.cloud.repository.ProductRepository;
import com.sagar.cloud.repository.UserRepository;

@RestController
public class JSONController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public List<User> getUserList(@PathVariable("id") Integer userId){
		return userRepository.findAll().stream().filter(s->s.getUserId()!=userId).collect(Collectors.toList());
	}
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	

}
