package com.sagar.cloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.cloud.model.Sales;

public interface SalesRepository extends JpaRepository<Sales, Integer>{

	List<Sales> findByCreatedDate(String createdDate);

}
