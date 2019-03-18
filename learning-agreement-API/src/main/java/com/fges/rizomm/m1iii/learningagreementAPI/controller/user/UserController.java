package com.fges.rizomm.m1iii.learningagreementAPI.controller.user;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.UserDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/user/")
public class UserController {
	@Autowired
	IUserService IUserService;

	/*
	@RequestMapping(value = "admin/addUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> addUser(@RequestBody CreateUserDTO createUserDto) {
		return new ResponseEntity<UserDTO>(IUserService.addUser(createUserDto), HttpStatus.OK);
	}

	/*
	@RequestMapping(value = "sendEmailForNewPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> sendEmailForNewPassword(@RequestBody String email) {
		User user = IUserService.getUserByEmail(email);
		if (user != null) {			
			try {
				IUserService.sendEmailForNewPassword(user);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
		}
		else
		{	
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}	
	}
	*/
	
	@RequestMapping(value = "updateUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto) {
		return new ResponseEntity<UserDTO>(IUserService.updateUser(userDto), HttpStatus.OK);
	}

	/*
	@RequestMapping(value = "setPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> setPassword(@RequestBody SetPasswordDTO setPasswordDto) {
		return new ResponseEntity<>(IUserService.setPassword(setPasswordDto), HttpStatus.OK);
	}
	*/
	
	@RequestMapping(value = "getUserById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long idUser) {
		return new ResponseEntity<>(IUserService.getUserById(idUser), HttpStatus.OK);
	}
	
	@RequestMapping(value = "getUserByToken/{token}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getUserByToken(@PathVariable("token") String token) {
		
		UserDTO u = IUserService.getUserByToken(token);
		
		if(u != null) {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		return new ResponseEntity<>(u, HttpStatus.NOT_FOUND);
		
	}

	/*
	@RequestMapping(value = "admin/changeUserStatus/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<void> changeUserStatus(@PathVariable("id") Long idUser) {
		return new ResponseEntity<>(IUserService.changeUserStatus(idUser), HttpStatus.OK);
	}
	*/
}
