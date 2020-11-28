package com.shoppingMaker.controller.member;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.shoppingMaker.repository.MemberRepository;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class MemberSignUpFormValidator implements Validator {
	
	private final MemberRepository repository;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return MemberSignUpForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		MemberSignUpForm signUpForm = (MemberSignUpForm)target;
		
		if(repository.existsByUserId(signUpForm.getUserId())) {
			errors.rejectValue("mId","error.mId","이미 사용중인 아이디입니다.");
		}
		if(repository.existsByEmail(signUpForm.getEmail())) {
			errors.rejectValue("email","error.email","이미 사용중인 이메일입니다.");
		}
		if(!signUpForm.getPassword().equals(signUpForm.getPasswordConfirm())) {
			errors.rejectValue("password","error.password","비밀번호가 일치하지 않습니다.");
		}
	}

	
	
}
