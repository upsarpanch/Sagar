package com.sagar.cloud.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagar.cloud.constant.Action;
import com.sagar.cloud.constant.Constant;
import com.sagar.cloud.model.Branch;
import com.sagar.cloud.model.Role;
import com.sagar.cloud.model.User;
import com.sagar.cloud.repository.BranchRepository;
import com.sagar.cloud.repository.UserRepository;

@Controller
public class RegisterController {

	Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BranchRepository branchRepository;

	@PostMapping(value = { "/register" })
	String getRegister(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String password, @RequestParam String mobileNumber, @RequestParam String address,
			@RequestParam String pinCode, @RequestParam String branchName, Model mv) {
		try {
			mv.addAttribute("title", Constant.TITLE);
			mv.addAttribute("action", Action.REGISTER);
			
			
			User user = User.builder().firstName(firstName).lastName(lastName).email(email)
					.password(password).mobileNumber(mobileNumber).address(address).pinCode(pinCode)
					.build();

			Role role = new Role();
			role.setRole("USER");
			user.setRoles(Collections.singleton(role));
			
			List<Branch> branchs=new ArrayList<Branch>();
			
			Branch branch=new Branch();
			branch.setBranchName(branchName);
			branch.setBranchAddress(address);
			branch.setBranchOwnerName(firstName+"\t"+lastName);
			branch.setCreatedDate(new Date().toString());
			branchs.add(branch);
			
            user.setBranch(branchs);
			if (user != null) {
				if (userRepository.findByEmail(email) != null) {
					mv.addAttribute("message", "Customer already register,please try new one!");
				} else {
					branchRepository.save(branch);
					userRepository.save(user);
					mv.addAttribute("message", "Customer Registration is done successfully!");
				}

			}

			return "/page-register";
		} catch (Exception e) {
			mv.addAttribute("error", e.getMessage());
			return "redirect:/pages-error.html";
		}
	}

}
