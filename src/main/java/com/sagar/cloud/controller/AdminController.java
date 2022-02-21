package com.sagar.cloud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sagar.cloud.constant.Constant;
import com.sagar.cloud.model.Product;
import com.sagar.cloud.model.Requirements;
import com.sagar.cloud.model.User;
import com.sagar.cloud.repository.BranchRepository;
import com.sagar.cloud.repository.ProductRepository;
import com.sagar.cloud.repository.RequirementsRepository;
import com.sagar.cloud.repository.SalesRepository;
import com.sagar.cloud.repository.UserRepository;
import com.sagar.cloud.rest.JSONController;
import com.sagar.cloud.service.ProductService;
import com.sagar.cloud.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	JSONController jsonController;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RequirementsRepository requirementsRepository;

	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	SalesRepository salesRepository;

	@GetMapping("/admin.html")
	public String getAdmin(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
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
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/page-error.html";
		}
	}

	@RequestMapping("/manage/{userId}/activation")
	public String getUserUpdate(@PathVariable Integer userId, Model model, HttpSession session,
			RedirectAttributes redirectAttributes) {

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
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/page-error.html";
		}
	}

	@RequestMapping("/{productId}/product/delete")
	public String getProductDelete(@PathVariable Integer productId, Model model, HttpSession session,
			RedirectAttributes redirectAttributes) {
		try {
			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}
			productService.getProductDeleteUpdate(productId);
			return "redirect:/admin/product-details.html";
		} catch (Exception e) {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/page-error.html";
		}
	}

	@GetMapping("/branch-details.html")
	public String getBranchListAdmin(Model model, HttpSession session) {
		try {
			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}
			model.addAttribute("userClickAdminBranchDetails", true);
			model.addAttribute("companyName", Constant.NAME);
			model.addAttribute("branches", branchRepository.findAll());
			return "/pages";
		} catch (Exception e) {
			return "redirect:/page-admin.html";
		}
	}
	
	@GetMapping("/sales-details.html")
	private String getSalesAdmin(HttpSession session, Model model) {
		try {
			
			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}
			model.addAttribute("title", Constant.TITLE);
			model.addAttribute("header_name", Constant.NAME);
			model.addAttribute("userClickSalesDetailsAdmin", true);
			model.addAttribute("companyName", Constant.NAME);
			model.addAttribute("sales", salesRepository.findAll());
			return "pages";
		} catch (Exception e) {
			return "redirect:/page-admin.html";
		}
	}

	@RequestMapping("/{userId}/delete")
	public String getUserDelete(@PathVariable Integer userId, Model model, HttpSession session,
			RedirectAttributes redirectAttributes) {
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
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/page-error.html";
		}
	}

	@GetMapping("/product.html")
	public String getProduct(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
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
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/page-error.html";
		}
	}

	@PostMapping("/product-add.html")
	public String getProductAdd(@RequestParam String item, @RequestParam double unitPrice, @RequestParam String unit,
			@RequestParam String quantity, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		try {

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}

			Product product = Product.builder().item(item).unitPrice(unitPrice).unit(unit).quantity(quantity).build();
			if (product == null) {
				redirectAttributes.addFlashAttribute("message", "Product is not inserted successfully!");
				return "redirect:/admin/success.html";
			}
			productRepository.save(product);
			redirectAttributes.addFlashAttribute("message", "Product is inserted successfully!");
			return "redirect:/admin/success.html";
		} catch (Exception e) {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/page-error.html";
		}
	}

	@GetMapping("/product-details.html")
	public String getProductList(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		try {

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}
			model.addAttribute("userClickAdminProductDetailsHome", true);
			model.addAttribute("companyName", Constant.NAME);
			model.addAttribute("products", jsonController.getProducts());
			return "/pages";
		} catch (Exception e) {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/page-error.html";
		}
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> uniqueMap = new ConcurrentHashMap<>();
		return t -> uniqueMap.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
	@GetMapping("/product-requirement-history.html")
	public String getProductRequirementHistory(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		try {
			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}

			List<Requirements> distinctElements = requirementsRepository.findAll().stream()
					.filter(t -> t.getStatus().equalsIgnoreCase("pending"))
					.filter(distinctByKey(cust -> cust.getCustomerId())).collect(Collectors.toList());

			model.addAttribute("userClickAdminProductRequirementHistory", true);
			model.addAttribute("products",
					distinctElements.parallelStream().map(t -> t.getUser()).collect(Collectors.toList()));
			model.addAttribute("companyName", Constant.NAME);
			return "/pages";
		} catch (Exception e) {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/page-error.html";
		}
	}

	@GetMapping("/product-requirement.html")
	public String getProductRequirement(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		try {
			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}

			List<Requirements> distinctElements = requirementsRepository.findAll().stream()
					.filter(t -> t.getStatus().equalsIgnoreCase("pending"))
					.filter(distinctByKey(cust -> cust.getCustomerId())).collect(Collectors.toList());

			model.addAttribute("userClickAdminProductRequirementHome", true);
			model.addAttribute("products",
					distinctElements.parallelStream().map(t -> t.getUser()).collect(Collectors.toList()));
			model.addAttribute("companyName", Constant.NAME);
			return "/pages";
		} catch (Exception e) {
			session.invalidate();
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/page-error.html";
		}
	}

	@GetMapping("/{userId}/product-requirement-view.html")
	public String getProductRequirementView(Model model, HttpSession session, @PathVariable("userId") Integer userId) {
		try {

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}

			List<Requirements> rs = new ArrayList<Requirements>();
			requirementsRepository.findAll().stream().filter(t -> {
				for (User user : t.getUser()) {
					if (userId == user.getUserId() && t.getStatus().equalsIgnoreCase("pending")) {
						rs.add(t);
					}
				}
				return false;
			}).collect(Collectors.toList());

			model.addAttribute("products", rs);
			model.addAttribute("netAmount", rs.stream().mapToDouble(p -> p.getNetAmount()).sum());
			model.addAttribute("userClickAdminProductRequirementHomeView", true);
			model.addAttribute("companyName", Constant.NAME);
			model.addAttribute("userId", userId);
			return "/pages";
		} catch (Exception e) {
			return "redirect:/page-admin.html";
		}
	}

	@RequestMapping("/{userId}/product-requirement-view-accept-all.html")
	public String getProductRequirementViewAcceptAll(Model model, HttpSession session,
			@PathVariable("userId") String userId) {
		try {

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/pages-admin.html";
			}

			List<Requirements> products = requirementsRepository.findByCustomerId(userId);

			for (Requirements p : products) {
				if (p.getStatus().equalsIgnoreCase("pending")) {
					p.setStatus("completed");
					requirementsRepository.saveAndFlush(p);
				}
			}

			model.addAttribute("userClickAdminSuccess", true);
			model.addAttribute("message", "All the order is proccessed!");
			model.addAttribute("companyName", Constant.NAME);
			return "/pages";
		} catch (Exception e) {
			return "redirect:/page-admin.html";
		}
	}

	@GetMapping("/{requirementId}/{userId}/product-requirement-view-accept.html")
	public String getProductRequirementViewAccept(Model model, HttpSession session,
			@PathVariable("requirementId") Integer requirementId, @PathVariable("userId") String userId) {
		try {

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}

			Requirements product = requirementsRepository.findByCustomerIdAndRequirements(requirementId, userId);
			if (product == null) {
				session.invalidate();
				return "redirect:/page-admin.html";
			}

			product.setStatus("completed");
			requirementsRepository.saveAndFlush(product);
			List<Requirements> rs = new ArrayList<Requirements>();
			requirementsRepository.findAll().stream().filter(t -> {
				for (User user : t.getUser()) {
					if (Integer.parseInt(userId) == user.getUserId() && t.getStatus().equalsIgnoreCase("pending")) {
						rs.add(t);
					}
				}
				return false;
			}).collect(Collectors.toList());

			model.addAttribute("products", rs);
			model.addAttribute("netAmount", rs.stream().mapToDouble(p -> p.getNetAmount()).sum());
			model.addAttribute("userClickAdminProductRequirementHomeView", true);
			model.addAttribute("companyName", Constant.NAME);
			model.addAttribute("userId", userId);
			return "/pages";
		} catch (Exception e) {
			return "redirect:/page-admin.html";
		}
	}

}
