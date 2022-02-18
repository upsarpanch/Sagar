package com.sagar.cloud.controller;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ccavenue.security.AesCryptUtil;
import com.sagar.cloud.constant.Action;
import com.sagar.cloud.constant.Constant;
import com.sagar.cloud.model.User;
import com.sagar.cloud.repository.RequirementsRepository;

@Controller
@RequestMapping("/customer")
public class PaymentController {

	@Autowired
	RequirementsRepository requirementsRepository;

	@RequestMapping("/payment-success.htm")
	public String getPaymentSuccess(Model model, HttpSession session) {
		try {

			if (session.getAttribute("userId") == null) {
				session.invalidate();
				return "redirect:/page-login.html";
			}
			model.addAttribute("userClickUserPaymentSuccess", true);
			return "pages";
		} catch (Exception e) {
			return "redirect:/page-error.html";
		}
	}

	@RequestMapping("/payment-failure.htm")
	public String getPaymentFailure(Model model, HttpSession session) {
		try {

			if (session.getAttribute("userId").toString() == null) {
				session.invalidate();
				return "redirect:/page-login.html";
			}
			model.addAttribute("userClickUserPaymentFailure", true);
			model.addAttribute("companyName", Constant.NAME);
			return "pages";
		} catch (Exception e) {
			return "redirect:/page-error.html";
		}
	}

	@RequestMapping("/payment-request.htm")
	public String getPaymentRequest(Model model, HttpSession session, HttpServletRequest request,
			@RequestParam("netAmount") String netAmount, @RequestParam("paymentMode") String paymentMode) {
		try {

			model.addAttribute("title", Constant.TITLE);
			model.addAttribute("header_name", Constant.NAME);
			model.addAttribute("companyName", Constant.NAME);

			String userId = session.getAttribute("userId").toString();

			if (userId == null) {
				session.invalidate();
				return "redirect:/page-login.html";
			}

			if (!paymentMode.equalsIgnoreCase("Online")) {
				requirementsRepository.findAll().stream().filter(t -> {
					
					for (User user : t.getUser()) {
						if (Integer.parseInt(userId) == user.getUserId() && t.getStatus().equalsIgnoreCase("0")) {
							t.setStatus("pending");
							t.setPaymentMode("Offline");
							requirementsRepository.saveAndFlush(t);
						}
					}
					
					return false;
				}).collect(Collectors.toList());

				model.addAttribute("userClickUserSuccess", true);
				model.addAttribute("message", "Order has been placed successfully!");
				return "pages";
			}

			Enumeration enumeration = request.getParameterNames();
			String ccaRequest = "", pname = "", pvalue = "";
			while (enumeration.hasMoreElements()) {
				pname = "" + enumeration.nextElement();
				pvalue = request.getParameter(pname);
				ccaRequest = ccaRequest + pname + "=" + pvalue + "&";
			}
			AesCryptUtil aesUtil = new AesCryptUtil(Constant.WORKING_KEY);
			String encRequest = aesUtil.encrypt(ccaRequest);
			model.addAttribute("encRequest", encRequest);
			model.addAttribute("accessCode", Constant.ACCESS_CODE);
			model.addAttribute("workingKey", Constant.WORKING_KEY);

			model.addAttribute("userClickUserPaymentRequest", true);
			model.addAttribute("payment", Action.PAYMENT_REQUEST);
			return "pages";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/page-error.html";
		}
	}

	@RequestMapping("/payment-response.htm")
	public String getCCAvanueResponse(Model model, HttpServletRequest request, HttpSession session) {
		try {

			if (session.getAttribute("userId").toString() == null) {
				session.invalidate();
				return "redirect:/page-login.html";
			}
			String encResp = request.getParameter("encResp");
			AesCryptUtil aesUtil = new AesCryptUtil(Constant.WORKING_KEY);
			String decResp = aesUtil.decrypt(encResp);
			StringTokenizer tokenizer = new StringTokenizer(decResp, "&");
			Hashtable hs = new Hashtable();
			String pair = null, pname = null, pvalue = null;
			while (tokenizer.hasMoreTokens()) {
				pair = (String) tokenizer.nextToken();
				if (pair != null) {
					StringTokenizer strTok = new StringTokenizer(pair, "=");
					pname = "";
					pvalue = "";
					if (strTok.hasMoreTokens()) {
						pname = (String) strTok.nextToken();
						if (strTok.hasMoreTokens())
							pvalue = (String) strTok.nextToken();
						hs.put(pname, pvalue);
					}
				}
			}

			Enumeration enumeration = hs.keys();
			while (enumeration.hasMoreElements()) {
				pname = "" + enumeration.nextElement();
				pvalue = "" + hs.get(pname);
				model.addAttribute("pname", pname);
				model.addAttribute("pvalue", pvalue);
			}
			return "pages";
		} catch (Exception e) {
			return "redirect:/page-login.html";
		}
	}

}
