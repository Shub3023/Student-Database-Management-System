package com.jspiders.smswithspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.smswithspringmvc.pojo.AdminPOJO;
import com.jspiders.smswithspringmvc.pojo.StudentPOJO;
import com.jspiders.smswithspringmvc.repository.AdminRepository;
import com.jspiders.smswithspringmvc.repository.StudentRepository;

@Component
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public void addAdmin(String name, String email, String password) {
		// TODO Auto-generated method stub

		AdminPOJO adminPOJO = new AdminPOJO();

		adminPOJO.setUserName(name);
		adminPOJO.setEmail(email);
		adminPOJO.setPassword(password);
		adminRepository.addStudent(adminPOJO);

	}

	public AdminPOJO logIn(String email, String password) {
		

		AdminPOJO flag = null;

		List<AdminPOJO> admins = adminRepository.getAllAdmin();

		for (AdminPOJO admin : admins) {

			if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {

				flag = admin;

			}
		}
		return flag;
	}

	public List<AdminPOJO> getAllAdmin() {
		// TODO Auto-generated method stub
		
		return adminRepository.getAllAdmin();
	}
	
	public void adminDelete(String email) {
		
		AdminPOJO adminToBeDeleted=null;
		
		List<AdminPOJO>admins = adminRepository.getAllAdmin();
		
		for(AdminPOJO admin:admins) {
			
			if(admin.getEmail().equals(email)) {
				
				adminToBeDeleted=admin;
				break;
			}
		}
		adminRepository.adminDelete(adminToBeDeleted);
	}

}
