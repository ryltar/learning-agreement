package com.fges.rizomm.m1iii.learningagreementAPI.controller.user;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.UserDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user/")
public class UserController {
	@Autowired
	IUserService userService;

	/*
	@RequestMapping(value = "admin/addUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> addUser(@RequestBody CreateUserDTO createUserDto) {
		return new ResponseEntity<UserDTO>(IUserService.addUser(createUserDto), HttpStatus.OK);
	}

	*/

	@RequestMapping(value = "updateUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto) {
		return new ResponseEntity<>(this.userService.updateUser(userDto), HttpStatus.OK);
	}
	
	@RequestMapping(value = "getUserById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long idUser) {
		return new ResponseEntity<>(this.userService.getUserById(idUser), HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDTO> findAllUsers() {
		return this.userService.getUsers();
	}

}
