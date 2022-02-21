package com.sagar.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	
	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("userClickHome", true);
		return "redirect:/page-login.html";
	}

	@GetMapping("/admin/logout")
	public String logoutAdmin(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("userClickAdmin", true);
		model.addAttribute("flag", false);
		return "redirect:/page-admin.html?panelId=770309";
	}



}
