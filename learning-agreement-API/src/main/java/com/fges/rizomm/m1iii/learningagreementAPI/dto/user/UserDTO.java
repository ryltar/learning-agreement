package com.fges.rizomm.m1iii.learningagreementAPI.dto.user;

import java.util.Collection;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.User;
import com.fges.rizomm.m1iii.learningagreementAPI.util.RoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO  {
	
	private Long id;

	private String username;

	private String firstname;

	private String lastname;

	private Collection<RoleEnum> roles;

	private String password;

	private boolean enabled;

	public UserDTO(String username, String firstname, String lastname, Collection<RoleEnum> roles, boolean enabled, String password) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.roles = roles;
		this.enabled = enabled;
		this.password = password;
	}

	public UserDTO(Long idUser, String username, String firstname, String lastname, Collection<RoleEnum> roles, boolean enabled) {
		this.id = idUser;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.roles = roles;
		this.enabled = enabled;
	}

}

