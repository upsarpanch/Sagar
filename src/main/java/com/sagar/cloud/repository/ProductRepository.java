package com.sagar.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.cloud.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	

}
