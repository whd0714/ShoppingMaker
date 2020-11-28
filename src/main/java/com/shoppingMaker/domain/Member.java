package com.shoppingMaker.domain;

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
	private String id;
	
	@Column(name = "m_id")
	private String mId;
	
	private String password;
	
	private String email;
	
	private String userName;
	
	
}
