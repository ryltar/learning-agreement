package com.fges.rizomm.m1iii.learningagreementAPI.dto.user;

import java.util.Collection;

import com.davidson.epack.dto.place.PlaceDTO;
import com.davidson.epack.util.RoleEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
	private Long idUser;

	private String username;

	private String firstname;

	private String lastname;
	
	private PlaceDTO place;
	
	private Collection<RoleEnum> roles;
	
	
	private boolean enabled;
	
	public UserDTO() {	}
	
	
	public UserDTO(String username, String firstname, String lastname, PlaceDTO place, Collection<RoleEnum> roles, boolean enabled) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.place = place;
		this.roles = roles;
		this.enabled = enabled;
	}
	
	public UserDTO(Long idUser, String username, String firstname, String lastname, PlaceDTO place, Collection<RoleEnum> roles, boolean enabled) {
		this.idUser = idUser;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.place = place;
		this.roles = roles;
		this.enabled = enabled;
	}
	
}

