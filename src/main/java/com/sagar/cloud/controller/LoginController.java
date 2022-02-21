package com.sagar.cloud.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sagar.cloud.constant.Constant;
import com.sagar.cloud.model.User;
import com.sagar.cloud.repository.UserRepository;

@Controller
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = { "/admin-validation" })
	String getAdminLogin(@RequestParam String email, @RequestParam String password, HttpServletRequest request,
			Model model,RedirectAttributes redirectAttributes) throws ServletException {
		try {
		User user = userRepository.findByEmail(email);

		if (user == null) {
			redirectAttributes.addFlashAttribute("message", "Cutsomer is not register,please register your account then,try!");
			return "redirect:/page-admin.html";
		}

		if (!user.getPassword().equalsIgnoreCase(password)) {
			redirectAttributes.addFlashAttribute("message", "Email & Password is not matching!");
			return "redirect:/page-admin.html";
		}

		if (user.getRoles().stream().filter(t -> t.getRole().equals("ADMIN")).count() == 0) {
			redirectAttributes.addFlashAttribute("message", "Your are not authorized for access this page!");
			return "redirect:/page-admin.html";
		}

		HttpSession session = request.getSession(true);
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("role", Constant.ADMIN_ROLE);
		session.setAttribute("userModel", user);
		return "redirect:/admin/admin.html";
		}catch(Exception e) {
			return "redirect:/page-admin.html";
		}
	}

	@RequestMapping(value = { "/login-validation" })
	String getLogin(@RequestParam String email, @RequestParam String password, 
			Model model,RedirectAttributes redirectAttributes, HttpServletRequest request) {
		try {
			User user = userRepository.findByEmail(email);

			if (user == null) {
				redirectAttributes.addFlashAttribute("message", "Cutsomer is not register,please register your account then,try!");
				return "redirect:/page-login.html";
			}

			if (user.getStatus() == 0) {
				redirectAttributes.addFlashAttribute("message", "Your are not register customer!");
				return "redirect:/page-login.html";
			}

			if (!user.getPassword().equalsIgnoreCase(password)) {
				redirectAttributes.addFlashAttribute("message", "Email & Password is not matching!");
				return "redirect:/page-login.html";
			}

			if (user.getRoles().stream().filter(t -> t.getRole().equals("USER")).count() == 0) {
				redirectAttributes.addFlashAttribute("message", "Your are not authorized for access this page!");
				return "redirect:/page-login.html";
			}

			HttpSession session = request.getSession(true);
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("role", Constant.USER_ROLE);
			session.setAttribute("userModel", user);
			return "redirect:/customer/user-product.html";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/page-error.html";
		}
	}

	

}
