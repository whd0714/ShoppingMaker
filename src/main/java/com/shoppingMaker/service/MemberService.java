package com.shoppingMaker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
				.userId(form.getUserId())
				.password(password)
				.email(form.getEmail())
				.username(form.getUsername())
				.build();
		
		member.settingNewMemberData();
		
		memberRepository.save(member);
		
		login(member);
	}
	
	public void login(Member member) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				member.getUserId(),
				member.getPassword(),
				List.of(new SimpleGrantedAuthority("ROLE_USER"))
				);
		SecurityContextHolder.getContext().setAuthentication(token);
				
	}
	
}
