package com.sagar.cloud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagar.cloud.constant.Action;
import com.sagar.cloud.constant.Constant;
import com.sagar.cloud.model.Product;
import com.sagar.cloud.model.Requirements;
import com.sagar.cloud.model.Sales;
import com.sagar.cloud.model.User;
import com.sagar.cloud.repository.ProductRepository;
import com.sagar.cloud.repository.RequirementsRepository;
import com.sagar.cloud.repository.SalesRepository;
import com.sagar.cloud.repository.UserRepository;
import com.sagar.cloud.rest.JSONController;

@Controller
@RequestMapping("/customer")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	JSONController jsonController;

	@Autowired
	RequirementsRepository requirementsRepository;

	@Autowired
	SalesRepository salesRepository;

	@GetMapping(value = { "/user-product.html" })
	public String getUserProduct(Model model, HttpSession session) {
		try {

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-login.html";
			}
			Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
			model.addAttribute("userClickUserProduct", true);
			model.addAttribute("products", jsonController.getProducts());
			model.addAttribute("companyName", Constant.NAME);
			model.addAttribute("redirect_url", Constant.REDIRECT_URL);
			model.addAttribute("cancel_url", Constant.CANCEL_URL);
			model.addAttribute("merchant_id", Constant.MERCHANT_ID);
			model.addAttribute("order_id", Constant.ORDER_ID);
			model.addAttribute("language", Constant.LANGUAGE);
			model.addAttribute("currency", "INR");

			List<Requirements> rs = new ArrayList<Requirements>();
			requirementsRepository.findAll().stream().filter(t -> {
				for (User user : t.getUser()) {
					if (userId == user.getUserId() && t.getStatus().equalsIgnoreCase("0")) {
						rs.add(t);

					}
				}
				return false;
			}).collect(Collectors.toList());
			
			
			model.addAttribute("productCheckouts", rs);
			model.addAttribute("netAmount", rs.stream().mapToDouble(p -> p.getNetAmount()).sum());

			return "pages";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "redirect:/page-error.html";
		}
	}

	@GetMapping(value = { "/product/{productId}" })
	public String getUserProductAdd(@PathVariable("productId") Integer id, Model model, HttpSession session) {
		try {
			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/pages-login.html";
			}

			Product product = productRepository.findById(id).orElse(null);
			model.addAttribute("userClickUserProductAddView", true);
			model.addAttribute("product", product);
			model.addAttribute("payment", Action.PAYMENT_REQUEST);
			model.addAttribute("action", Action.PRODUCT);
			model.addAttribute("companyName", Constant.NAME);
			return "pages";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "redirect:/page-error.html";
		}
	}

	@PostMapping(value = { "/product-add.html" })
	public String getUserProductAdded(Model model, HttpSession session, @RequestParam("netAmount") String netAmount,
			@RequestParam("quantity") String quantity, @RequestParam("item") String item,
			@RequestParam("unit") String unit) {
		try {

			model.addAttribute("title", Constant.TITLE);
			model.addAttribute("header_name", Constant.NAME);
			model.addAttribute("userClickUserSuccess", true);
			model.addAttribute("companyName", Constant.NAME);

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-login.html";
			}

			Requirements reqs = requirementsRepository.findByItem(item);

			if (reqs != null) {

				model.addAttribute("message", "Already Item Record added,please try new one!");
				return "pages";
			}

			List<User> users = new ArrayList<User>();
			User user = userRepository.findById(Integer.parseInt(session.getAttribute("userId").toString()))
					.orElse(null);
			users.add(user);

			Requirements req = new Requirements();
			req.setCreatedDate(new Date().toString());
			req.setPaymentMode("0");
			req.setItem(item);
			req.setNetAmount(Double.parseDouble(netAmount));
			req.setQuantity(quantity);
			req.setUnit(unit);
			req.setStatus("0");
			req.setUser(users);
			requirementsRepository.save(req);

			model.addAttribute("message", "Item Record is added successfully!");
			return "pages";

		} catch (Exception e) {
			return "redirect:/page-error.html";
		}
	}

	@GetMapping(value = { "/user-daily-sales.html" })
	public String getSales(Model model, HttpSession session) {

		try {

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-login.html";
			}
			model.addAttribute("title", Constant.TITLE);
			model.addAttribute("header_name", Constant.NAME);
			model.addAttribute("userClickSalesUser", true);
			model.addAttribute("action", "/customer/salesSave.html");
			model.addAttribute("companyName", Constant.NAME);
			return "pages";
		} catch (Exception e) {
			return "redirect:/page-error.html";
		}
	}

	@PostMapping("/salesSave.html")
	private String productSave(@RequestParam Double totalSales, @RequestParam String createdDate, Model model,
			HttpSession session) {
		try {

			model.addAttribute("title", Constant.TITLE);
			model.addAttribute("header_name", Constant.NAME);
			model.addAttribute("userClickUserSuccess", true);
			model.addAttribute("companyName", Constant.NAME);

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-login.html";
			}

			List<User> users = new ArrayList<User>();

			User user = userRepository.findById(Integer.parseInt(session.getAttribute("userId").toString()))
					.orElse(null);
			users.add(user);
			if (user == null) {
				return "redirect:/page-error.html";
			}

			List<Sales> sales = salesRepository.findByCreatedDate(createdDate);

			List<Sales> saleCheck = new ArrayList<Sales>();

			sales.stream().filter(t -> {

				for (User u : t.getUser()) {
					if (user.getUserId() == u.getUserId() && t.getCreatedDate().equalsIgnoreCase(createdDate)) {

						saleCheck.add(t);
					}
				}
				return false;

			}).collect(Collectors.toList());

			if (!saleCheck.isEmpty()) {
				model.addAttribute("message", "Sales Record is added already,please try new one!");
				return "pages";
			}

			Sales sale = new Sales();
			sale.setTotalSales(totalSales);
			sale.setCreatedDate(createdDate);
			sale.setUser(users);
			salesRepository.save(sale);

			model.addAttribute("message", "Sales Record is added successfully!");
			return "pages";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/page-error.html";
		}
	}

	@GetMapping(value = { "/sales-history.html" })
	public String getSalesHistory(Model model, HttpSession session) {

		try {

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-login.html";
			}
			model.addAttribute("title", Constant.TITLE);
			model.addAttribute("header_name", Constant.NAME);
			model.addAttribute("userClickSalesHistory", true);
			model.addAttribute("companyName", Constant.NAME);
			List<Sales> saleCheck = new ArrayList<Sales>();
			List<Sales> sales = salesRepository.findAll();

			sales.stream().filter(t -> {

				for (User u : t.getUser()) {
					if (Integer.parseInt(session.getAttribute("userId").toString()) == u.getUserId()) {

						saleCheck.add(t);
					}
				}
				return false;

			}).collect(Collectors.toList());
			model.addAttribute("sales", saleCheck);
			return "pages";
		} catch (Exception e) {
			return "redirect:/page-error.html";
		}
	}

	@GetMapping(value = { "/product_requirement_history.html" })
	public String getProductRequirementHistory(Model model, HttpSession session) {

		try {

			Integer userId = Integer.parseInt(session.getAttribute("userId").toString());

			if (userId == null) {
				session.invalidate();
				return "redirect:/page-login.html";
			}

			model.addAttribute("title", Constant.TITLE);
			model.addAttribute("header_name", Constant.NAME);
			model.addAttribute("userClickProductRequirementHistory", true);
			model.addAttribute("companyName", Constant.NAME);
			
			//System.out.println(requirementsRepository.findUserRequirements(userId));

			List<Requirements> rs = new ArrayList<Requirements>();
			requirementsRepository.findAll().stream().filter(t -> {
				for (User user : t.getUser()) {
					if (userId == user.getUserId() && !t.getStatus().equalsIgnoreCase("0")) {
						rs.add(t);

					}
				}
				return false;
			}).collect(Collectors.toList());

			model.addAttribute("products", rs);

			return "pages";
		} catch (Exception e) {
			return "redirect:/page-error.html";
		}
	}

	@GetMapping(value = { "/product/{requirementId}/delete" })
	public String getUserProductDelete(@PathVariable("requirementId") Integer requirementId, Model model,
			HttpSession session) {
		try {

			if (session.getAttribute("userId").toString() == null) {
				session.invalidate();
				return "redirect:/page-login.html";
			}

			requirementsRepository.deleteById(requirementId);
			return "redirect:/customer/user-product.html";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/page-error.html";
		}
	}

}
