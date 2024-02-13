package com.jspiders.smswithspringmvc.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AdminPOJO {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private long id;
	@Column(nullable = true )
	private String userName;
	@Column(nullable = true , unique = true)
	private String email;
	@Column(nullable = true ,unique = false)
	private String password;

}
