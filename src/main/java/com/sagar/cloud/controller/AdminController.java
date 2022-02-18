package com.sagar.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagar.cloud.constant.Constant;
import com.sagar.cloud.model.Product;
import com.sagar.cloud.repository.ProductRepository;
import com.sagar.cloud.rest.JSONController;
import com.sagar.cloud.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	JSONController jsonController;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserService userService;

	@GetMapping("/admin.html")
	public String getAdmin(Model model, HttpSession session) {
		try {
			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}
			model.addAttribute("userClickAdminDashboardHome", true);
			model.addAttribute("companyName", Constant.NAME);
			model.addAttribute("users",
					jsonController.getUserList(Integer.parseInt(session.getAttribute("userId").toString())));
			return "/pages";
		} catch (Exception e) {
			session.invalidate();
			model.addAttribute("error", e.getMessage());
			return "redirect:/page-error.html?error=" + e.getMessage();
		}
	}

	@RequestMapping("/manage/{userId}/activation")
	public String getUserUpdate(@PathVariable Integer userId, Model model, HttpSession session) {

		try {
			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}
			model.addAttribute("message", userService.getUserUpdate(userId));
			model.addAttribute("userClickAdminSuccess", true);
			model.addAttribute("companyName", Constant.NAME);
			return "/pages";
		} catch (Exception e) {
			session.invalidate();
			model.addAttribute("error", e.getMessage());
			return "redirect:/page-error.html?error=" + e.getMessage();
		}
	}

	@RequestMapping("/{userId}/product/delete")
	public String getProductDelete(@PathVariable Integer userId, Model model, HttpSession session) {
		try {
			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/pages-admin.html";
			}
			model.addAttribute("message", userService.getDeleteUpdate(userId));
			model.addAttribute("userClickAdminSuccess", true);
			model.addAttribute("companyName", Constant.NAME);
			return "/pages";
		} catch (Exception e) {
			return "redirect:/page-error.html?error=" + e.getMessage();
		}
	}

	@RequestMapping("/{userId}/delete")
	public String getUserDelete(@PathVariable Integer userId, Model model, HttpSession session) {
		try {
			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}
			model.addAttribute("message", userService.getDeleteUpdate(userId));
			model.addAttribute("userClickAdminSuccess", true);
			model.addAttribute("companyName", Constant.NAME);
			return "/pages";
		} catch (Exception e) {
			return "redirect:/page-error.html?error=" + e.getMessage();
		}
	}

	@GetMapping("/product.html")
	public String getProduct(Model model, HttpSession session) {
		try {

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}
			model.addAttribute("userClickAdminProductHome", true);
			model.addAttribute("companyName", Constant.NAME);
			model.addAttribute("action", "/admin/product-add.html");
			return "/pages";
		} catch (Exception e) {
			return "redirect:/page-error.html?error=" + e.getMessage();
		}
	}

	@PostMapping("/product-add.html")
	public String getProductAdd(@RequestParam String item, @RequestParam double unitPrice, @RequestParam String unit,
			@RequestParam String quantity, Model model, HttpSession session) {
		try {

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}
			model.addAttribute("userClickAdminSuccess", true);
			model.addAttribute("companyName", Constant.NAME);
			model.addAttribute("action", "/admin/product-add.html");

			Product product = Product.builder().item(item).unitPrice(unitPrice).unit(unit).quantity(quantity).build();
			if (product == null) {
				model.addAttribute("message", "Product is not inserted successfully!");
				return "/pages";
			}
			productRepository.save(product);
			model.addAttribute("message", "Product is inserted successfully!");
			return "/pages";
		} catch (Exception e) {
			return "redirect:/page-error.html?error=" + e.getMessage();
		}
	}

	@GetMapping("/product-details.html")
	public String getProductList(Model model, HttpSession session) {
		try {

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/pages-admin.html";
			}
			model.addAttribute("userClickAdminProductDetailsHome", true);
			model.addAttribute("companyName", Constant.NAME);
			model.addAttribute("products", jsonController.getProducts());
			return "/pages";
		} catch (Exception e) {
			return "redirect:/page-error.html?error=" + e.getMessage();
		}
	}

}
