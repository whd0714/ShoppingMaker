package com.shoppingMaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingMaker.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	boolean existsByUserId(String userId);
	
	boolean existsByEmail(String email);
	
}
