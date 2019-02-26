package com.fges.rizomm.m1iii.learningagreementAPI.controller.user;

import java.util.List;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.UserDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.User;
import com.fges.rizomm.m1iii.learningagreementAPI.services.user.UserService;
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
	UserService userService;

	/*
	@RequestMapping(value = "admin/addUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> addUser(@RequestBody CreateUserDTO createUserDto) {
		return new ResponseEntity<UserDTO>(userService.addUser(createUserDto), HttpStatus.OK);
	}

	/*
	@RequestMapping(value = "sendEmailForNewPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> sendEmailForNewPassword(@RequestBody String email) {
		User user = userService.getUserByEmail(email);
		if (user != null) {			
			try {
				userService.sendEmailForNewPassword(user);
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
		return new ResponseEntity<UserDTO>(userService.updateUser(userDto), HttpStatus.OK);
	}

	/*
	@RequestMapping(value = "setPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> setPassword(@RequestBody SetPasswordDTO setPasswordDto) {
		return new ResponseEntity<>(userService.setPassword(setPasswordDto), HttpStatus.OK);
	}
	*/
	
	@RequestMapping(value = "getUserById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long idUser) {
		return new ResponseEntity<>(userService.getUserById(idUser), HttpStatus.OK);
	}
	
	@RequestMapping(value = "getUserByToken/{token}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getUserByToken(@PathVariable("token") String token) {
		
		UserDTO u = userService.getUserByToken(token);
		
		if(u != null) {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		return new ResponseEntity<>(u, HttpStatus.NOT_FOUND);
		
	}

	/*
	@RequestMapping(value = "admin/getUsers/{idSite}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> getUsers(@PathVariable("idSite") Long idSite) {
		return new ResponseEntity<>(userService.getUsers(idSite), HttpStatus.OK);
	}
	
	@RequestMapping(value = "admin/changeUserStatus/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<void> changeUserStatus(@PathVariable("id") Long idUser) {
		return new ResponseEntity<>(userService.changeUserStatus(idUser), HttpStatus.OK);
	}
	*/
}
