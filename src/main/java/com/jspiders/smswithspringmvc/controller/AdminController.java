package com.jspiders.smswithspringmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.smswithspringmvc.pojo.AdminPOJO;
import com.jspiders.smswithspringmvc.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String getToHomePage() {

		return "home";

	}

	@RequestMapping(path = "/Log_in", method = RequestMethod.GET)
	public String toGetLogInPage() {

		return "Log_in";

	}

	@RequestMapping(path = "/add_admin", method = RequestMethod.GET)
	public String addAdmin(ModelMap map) {

		List<AdminPOJO> admins = adminService.getAllAdmin();

		if (admins.size() < 3) {

			map.addAttribute("message", "admin added.");
			return "add_admin";
		} else {

			map.addAttribute("message", "admin Aleredy Exists.");
			return "Log_in";
		}

	}

	@RequestMapping(path = "/add_admin", method = RequestMethod.POST)
	public String addAdmin(@RequestParam String userName, @RequestParam String email, @RequestParam String password,
			ModelMap map) {
		adminService.addAdmin(userName, email, password);

		return "Log_In";

	}

	@RequestMapping(path = "/Log_in", method = RequestMethod.POST)
	public String logIn(@RequestParam String email, @RequestParam String password, ModelMap modelMap,
			HttpSession httpSession) {

		AdminPOJO flag = adminService.logIn(email, password);
		httpSession.setMaxInactiveInterval(1800);

		if (flag != null) {
			httpSession.setAttribute("admin", flag);
			modelMap.addAttribute("message", email);
			return "welcome";
		} else {

			return "add_admin";
		}

	}

	@RequestMapping(path = "/Log_Out", method = RequestMethod.GET)
	public String Log_Out(HttpSession httpSession) {
		httpSession.invalidate();
		return "Log_in";

	}

	@RequestMapping(path = "/delete_admin", method = RequestMethod.GET)
	public String adminDelete(@RequestParam String email, ModelMap modelMap) {

		adminService.adminDelete(email);

		modelMap.addAttribute("message", "Admin Deleted.");
		return "Log_in";

	}

}
