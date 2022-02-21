package com.sagar.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sagar.cloud.constant.Constant;

@Controller
public class MessageController {

	@GetMapping("/admin/success.html")
	public String getAdminSuccess(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			session.invalidate();
			return "redirect:/page-admin.html";
		}
		model.addAttribute("title", Constant.TITLE);
		model.addAttribute("header_name", Constant.NAME);
		model.addAttribute("userClickAdminSuccess", true);
		model.addAttribute("companyName", Constant.NAME);
		return "pages";
	}
	
	@GetMapping("/customer/success.html")
	public String getUserSuccess(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			session.invalidate();
			return "redirect:/page-login.html";
		}
		model.addAttribute("title", Constant.TITLE);
		model.addAttribute("header_name", Constant.NAME);
		model.addAttribute("userClickUserSuccess", true);
		model.addAttribute("companyName", Constant.NAME);
		return "pages";
	}

}
