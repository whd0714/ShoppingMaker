package com.shoppingMaker.controller.member;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.shoppingMaker.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	private final MemberSignUpFormValidator memberSignUpFormValidator;
	
	@InitBinder("memberSignUpForm")
	public void memberSignUpFormBinder(WebDataBinder binder) {
		binder.addValidators(memberSignUpFormValidator);
	}
	
	@GetMapping("/sign-up")
	public String viewSignUpForm(Model model) {
		model.addAttribute(new MemberSignUpForm());
		
		return "sign-up";
	}

	
	@PostMapping("/sign-up")
	public String processSignUp(@Valid MemberSignUpForm form, Errors errors) {
		if(errors.hasErrors()) {
			return "sign-up";
		}
		
		memberService.createNewMember(form);
		
		return "";
	}
	
	
}
