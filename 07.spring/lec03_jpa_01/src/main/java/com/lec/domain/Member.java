package com.lec.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
public class Member {

	@Id
	private String member_id;
	private String name;
	private String password;
	private String role;
	
}
