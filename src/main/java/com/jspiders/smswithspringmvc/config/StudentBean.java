package com.jspiders.smswithspringmvc.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentBean {
	
	@Bean
	public EntityManager getStudent() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sms_with_spring_mvc");
		
		return entityManagerFactory.createEntityManager()  ;
		
		
	}

}
