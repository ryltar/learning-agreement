package com.fges.rizomm.m1iii.learningagreementAPI.services.user;

import java.util.List;
import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.UserDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.User;

public interface UserService {

	//List<UserDTO> getUsers(Long idSite);

	User findById(Long idUser);

	UserDTO getUserById(Long id);

	void changeUserStatus(Long idUser);

	UserDTO getUserDtoByEmail(String email);

	User getUserByUsername(String email);

	UserDTO getUserByToken(String token);

	UserDTO setPassword(UserDTO userDTO);

	UserDTO updateUser(UserDTO userDto);

}
