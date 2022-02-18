package com.sagar.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sagar.cloud.constant.Action;
import com.sagar.cloud.constant.Constant;

@Controller
public class IndexController {
	
	Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@GetMapping(value = { "/login", "/page-login.html" })
	String getIndex(Model mv) {
		mv.addAttribute("title", Constant.TITLE);
		mv.addAttribute("NAME", Constant.NAME);
		mv.addAttribute("action", Action.LOGIN);
		mv.addAttribute("userClickUser", true);
		mv.addAttribute("companyName", Constant.NAME);
		return "/page-login";
	}
	
	@GetMapping(value = {"/page-error.html" })
	String getError(Model mv) {
		mv.addAttribute("title", Constant.TITLE);
		mv.addAttribute("NAME", Constant.NAME);
		mv.addAttribute("action", Action.LOGIN);
		mv.addAttribute("userClickError", true);
		mv.addAttribute("companyName", Constant.NAME);
		return "/page-error";
	}

	@GetMapping(value = { "/page-admin.html" })
	String getAdmin(Model mv) {
		mv.addAttribute("title", Constant.TITLE);
		mv.addAttribute("NAME", Constant.NAME);
		mv.addAttribute("action", Action.ADMIN);
		mv.addAttribute("userClickAdmin", true);
		mv.addAttribute("companyName", Constant.NAME);
		return "/page-admin";
	}

	@GetMapping(value = { "/dashboard.html", "/" })
	String getMainDashboard(Model mv) {
		mv.addAttribute("title", Constant.TITLE);
		mv.addAttribute("NAME", Constant.NAME);
		mv.addAttribute("userClickUserMainDashboard", true);
		mv.addAttribute("companyName", Constant.NAME);
		return "/pages";
	}

	@GetMapping(value = { "/about.html" })
	String getAboutUs(Model mv) {
		mv.addAttribute("title", Constant.TITLE);
		mv.addAttribute("NAME", Constant.NAME);
		mv.addAttribute("userClickAboutUs", true);
		mv.addAttribute("companyName", Constant.NAME);
		return "/pages";
	}

	@GetMapping(value = { "/contact.html" })
	String getContactUs(Model mv) {
		mv.addAttribute("title", Constant.TITLE);
		mv.addAttribute("NAME", Constant.NAME);
		mv.addAttribute("userClickContactUs", true);
		mv.addAttribute("action", Action.CONTACT);
		mv.addAttribute("companyName", Constant.NAME);
		return "/pages";
	}

	@GetMapping(value = { "/signup", "/page-register.html" })
	String getSignUp(Model mv) {
		mv.addAttribute("title", Constant.TITLE);
		mv.addAttribute("NAME", Constant.NAME);
		mv.addAttribute("action", Action.REGISTER);
		mv.addAttribute("userClickRegister", true);
		mv.addAttribute("companyName", Constant.NAME);
		return "/page-register";
	}
	
	
}
