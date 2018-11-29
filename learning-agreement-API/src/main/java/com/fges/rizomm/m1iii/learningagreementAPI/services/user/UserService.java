package com.fges.rizomm.m1iii.learningagreementAPI.services.user;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.davidson.epack.dto.user.CreateUserDTO;
import com.davidson.epack.dto.user.SetPasswordDTO;
import com.davidson.epack.dto.user.UserDTO;
import com.davidson.epack.entity.user.User;
import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.UserDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.User;

import javax.mail.MessagingException;

public interface UserService {

	UserDTO addUser(CreateUserDTO createUserDto);

	List<UserDTO> getUsers(Long idSite);

	User findById(Long idUser);

	UserDTO getUserById(Long id);

	Void changeUserStatus(Long idUser);

	UserDTO getUserDtoByEmail(String email);

	User getUserByEmail(String email);

	void sendEmailForNewPassword(User user) throws UnsupportedEncodingException, MessagingException;

	UserDTO getUserByToken(String token);

	UserDTO setPassword(SetPasswordDTO setPasswordDto);

	UserDTO updateUser(UserDTO userDto);

}
