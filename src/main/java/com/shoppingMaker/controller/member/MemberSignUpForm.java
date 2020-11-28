package com.shoppingMaker.controller.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class MemberSignUpForm {

	@NotBlank
	@Length(min = 3, max = 15)
	//@Pattern(regexp = "^{a-zA-Z0-9}[3,15]$")
	private String userId;
	
	@NotBlank
	@Length(min = 8, max = 30)
	private String password;
	
	@NotBlank
	@Length(min = 8, max = 30)
	private String passwordConfirm;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Length(min = 3, max = 10)
	//@Pattern(regexp = "^{가-힣a-zA-Z}[3,10]$")
	private String username;


	
}
