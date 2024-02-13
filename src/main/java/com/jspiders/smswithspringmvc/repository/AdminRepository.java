package com.jspiders.smswithspringmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.smswithspringmvc.pojo.AdminPOJO;

@Component
public class AdminRepository {

	@Autowired
	EntityManager entityManager;

	public void addStudent(AdminPOJO adminPOJO) {

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(adminPOJO);
		entityTransaction.commit();

	}

	public List<AdminPOJO> getAllAdmin() {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("SELECT admin FROM AdminPOJO admin");
		List<AdminPOJO> admins = query.getResultList();
		entityTransaction.commit();
		return admins;
	}

	public void adminDelete(AdminPOJO adminToBeDeleted) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(adminToBeDeleted);
		entityTransaction.commit();
		
	}

}
