package com.shoppingMaker.service;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shoppingMaker.controller.member.MemberSignUpForm;
import com.shoppingMaker.domain.Member;
import com.shoppingMaker.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	public void createNewMember(MemberSignUpForm form) {
		String password = passwordEncoder.encode(form.getPassword());
		Member member = Member.builder()
				.mId(form.getMId())
				.password(password)
				.email(form.getEmail())
				.userName(form.getUsername())
				.build();
		
		memberRepository.save(member);
	}
	
	
}
