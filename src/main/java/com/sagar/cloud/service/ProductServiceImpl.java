package com.sagar.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.cloud.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public String getProductUpdate(Integer productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProductDeleteUpdate(Integer productId) {
		productRepository.deleteById(productId);
		return "Product is deleted successfully!";
	}

}
