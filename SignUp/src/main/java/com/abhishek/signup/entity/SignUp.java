package com.abhishek.signup.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class SignUp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer id;
	
	@Column(name = "USER_NAME")
	private String name;
	
	@Column(name = "USER_MOBILE_NO")
	private Long mobileNo;
	
	@Column(name="USER_EMAIL_ID")
	private String emailId;
	
	

}
