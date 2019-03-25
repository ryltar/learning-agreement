package com.fges.rizomm.m1iii.learningagreementAPI.controller.user;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.UserDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
	@Autowired
	IUserService userService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDTO> findAllUsers() {
		return this.userService.getUsers();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO findOneCourse(@PathVariable Long id) {
		return this.userService.findOne(id);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO addCourse(@RequestBody UserDTO courseDTO) {
		return this.userService.addUser(courseDTO);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO editCourse(@RequestBody UserDTO userDTO, @PathVariable Long id) {
		return this.userService.updateUser(userDTO, id);
	}

}
