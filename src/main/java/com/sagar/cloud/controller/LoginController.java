package com.sagar.cloud.controller;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagar.cloud.constant.Constant;
import com.sagar.cloud.model.User;
import com.sagar.cloud.repository.UserRepository;

@Controller
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserRepository userRepository;

	@PostMapping(value = { "/admin-validation" })
	String getAdminLogin(@RequestParam String email, @RequestParam String password, HttpServletRequest request,
			Model model) throws ServletException {
		User user = userRepository.findByEmail(email);

		if (user == null) {
			model.addAttribute("message", "Cutsomer is not register,please register your account then,try!");
			return "/page-admin";
		}

		if (!user.getPassword().equalsIgnoreCase(password)) {
			model.addAttribute("message", "Email & Password is not matching!");
			return "/page-admin";
		}

		if (user.getRoles().stream().filter(t -> t.getRole().equals("ADMIN")).count() == 0) {
			model.addAttribute("message", "Your are not authorized for access this page!");
			return "/page-admin";
		}

		HttpSession session = request.getSession(true);
		addUserInSession(session, user.getUserId(), Constant.ADMIN_ROLE);
		return "redirect:/admin/admin.html";
	}

	@PostMapping(value = { "/login-validation" })
	String getLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
		try {
			User user = userRepository.findByEmail(email);

			if (user == null) {
				model.addAttribute("message", "Cutsomer is not register,please register your account then,try!");
				return "/pages-login";
			}

			if (user.getStatus() == 0) {
				model.addAttribute("message", "Your are not register customer!");
				return "/page-login";
			}

			if (!user.getPassword().equalsIgnoreCase(password)) {
				model.addAttribute("message", "Email & Password is not matching!");
				return "/page-login";
			}

			if (user.getRoles().stream().filter(t -> t.getRole().equals("USER")).count() == 0) {
				model.addAttribute("message", "Your are not authorized for access this page!");
				return "redirect:/pages-admin.html";
			}

			addUserInSession(session, user.getUserId(), Constant.USER_ROLE);
			session.setAttribute("userId", user.getUserId());
			return "redirect:/customer/user-product.html";
		} catch (Exception e) {
			return "redirect:/page-login.html";
		}
	}

	public void addUserInSession(HttpSession session, Integer userId, String role) {
		try {
			session.setAttribute("userId", userId);
			session.setAttribute("role", role);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
