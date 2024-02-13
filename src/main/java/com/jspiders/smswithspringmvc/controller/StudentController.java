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
import com.jspiders.smswithspringmvc.pojo.StudentPOJO;
import com.jspiders.smswithspringmvc.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(path = "/add_student", method = RequestMethod.GET)
	public String getPageToAddStudent(HttpSession httpSession) {

		AdminPOJO admin = (AdminPOJO) httpSession.getAttribute("admin");
		if (admin != null) {
			return "add_student";
		} else {

			return "Log_in";
		}

	}

	@RequestMapping(path = "/add_student", method = RequestMethod.POST)
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam long mobile,
			@RequestParam byte age, ModelMap modelMap, HttpSession httpSession) {

		studentService.addStudent(name, email, mobile, age);
		modelMap.addAttribute("message", "student added.");

		return "add_student";
	}

	@RequestMapping(path = "/get_students", method = RequestMethod.GET)
	public String getAllStudent(ModelMap modelMap, HttpSession httpSession) {

		AdminPOJO admin = (AdminPOJO) httpSession.getAttribute("admin");
		if (admin != null) {

			List<StudentPOJO> student = studentService.getAllStudent();

			modelMap.addAttribute("students", student);

			return "get_students";
		} else {
			return "Log_in";
		}

	}

	@RequestMapping(path = "/delete_student", method = RequestMethod.GET)
	public String deleteStudent(ModelMap modelMap, HttpSession httpSession) {

		AdminPOJO admin = (AdminPOJO) httpSession.getAttribute("admin");

		if (admin != null) {
			List<StudentPOJO> student = studentService.getAllStudent();
			modelMap.addAttribute("students", student);
			return "delete_student";
		} else {

			return "Log_in";
		}

	}

	@RequestMapping(path = "/delete_student", method = RequestMethod.POST)
	public String deleteStudent(@RequestParam int id, ModelMap modelMap) {
		String message = studentService.deleteStudent(id);
		modelMap.addAttribute("message", message);
		List<StudentPOJO> student = studentService.getAllStudent();
		modelMap.addAttribute("students", student);
		return "delete_student";

	}

	@RequestMapping(path = "/edit_student", method = RequestMethod.GET)
	public String editStudent(HttpSession httpSession) {

		AdminPOJO admin = (AdminPOJO) httpSession.getAttribute("admin");

		if (admin != null) {

			return "edit_student";

		} else {

			return "Log_in";
		}
	}

	@RequestMapping(path = "/edit_student", method = RequestMethod.POST)
	public String editStudent(@RequestParam int id, ModelMap modelMap) {

		StudentPOJO student = studentService.editStudent(id);

		modelMap.addAttribute("students", student);

		return "update_student";

	}

	public String getHomePage() {

		return "home";

	}

	@RequestMapping(path = "/update_student", method = RequestMethod.POST)
	public String updateStudent(@RequestParam long id, @RequestParam String name, @RequestParam String email,
			@RequestParam long mobile, @RequestParam byte age, ModelMap modelMap) {

		studentService.updateStudent(id, name, email, mobile, age);
		modelMap.addAttribute("message", "Student Updated.");

		return "edit_student";
	}
	
	@RequestMapping(path = "/pattern",method=RequestMethod.GET)
	public String getStudentPatternPage() {
		
		return "pattern";
		
	}
	
	@RequestMapping(path = "/pattern",method=RequestMethod.POST)
	public String getStudentByPattern(@RequestParam String pattern, ModelMap modelMap) {
		
		List<StudentPOJO> students=studentService.getStudentByPattern(pattern);
		
		modelMap.addAttribute("student",students);
		return "pattern";
		
	}

}
