package com.sagar.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.cloud.model.User;
import com.sagar.cloud.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> users() {
		return userRepository.findAll();
	}

	public String getUserUpdate(Integer userId) {
		User user = userRepository.findById(userId).orElse(null);
		int isActive = user.getStatus();
		boolean flag;

		if (isActive == 0) {
			user.setStatus(1);
			flag = true;
		} else {
			user.setStatus(0);
			flag = false;
		}
		userRepository.saveAndFlush(user);
		return (flag) ? "User Activated Successfully" : "User De-activated Successfully!";
	}

	public String getDeleteUpdate(Integer userId) {

		userRepository.deleteById(userId);
		return "Customer is deleted successfully!";

	}

}
