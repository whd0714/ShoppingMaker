package com.shoppingMaker.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;
	
	@Column(unique = true)
	private String userId;
	
	private String password;
	
	@Column(unique = true)
	private String email;
	
	private String username;
	
	private LocalDateTime joinAt;
	
	public void settingNewMemberData() {
		this.joinAt = LocalDateTime.now();
	}
	
}
