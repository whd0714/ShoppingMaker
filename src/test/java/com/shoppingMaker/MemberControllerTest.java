package com.shoppingMaker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.shoppingMaker.controller.member.MemberSignUpForm;
import com.shoppingMaker.domain.Member;
import com.shoppingMaker.repository.MemberRepository;
import com.shoppingMaker.service.MemberService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MemberControllerTest {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	MemberService memberService;

	@Autowired
	MockMvc mockMvc;

	
	  @Test 
	  public void 유저가입() {
	  
	  MemberSignUpForm form = new MemberSignUpForm(); form.setUserId("member1");
	  form.setPassword("123456789"); form.setPasswordConfirm("123456789");
	  form.setEmail("member1@naver.com"); form.setUsername("회원1");
	  
	  memberService.createNewMember(form);
	  
	  Member findByUsername = memberRepository.findByUsername("회원1");
	  
	  assertThat(findByUsername.getUsername()).isEqualTo("회원1"); }
	 
	  
	@Test
	public void 유저가입2() throws Exception {

		mockMvc.perform(post("/sign-up")
				.param("userId","member1")
				.param("password", "123456789")
				.param("passwordConfirm","123456789")
				.param("email","member1@naver.com")
				.param("username","일번남")
				.contentType(MediaType.APPLICATION_JSON)
				.with(csrf())
				)
				.andDo(print())
				.andExpect(status().is3xxRedirection());

	}

}
