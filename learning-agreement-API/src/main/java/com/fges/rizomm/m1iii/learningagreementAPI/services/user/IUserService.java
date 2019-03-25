package com.fges.rizomm.m1iii.learningagreementAPI.services.user;

import java.util.List;
import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.UserDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.User;

public interface IUserService {

	UserDTO getUserById(Long id);

	UserDTO updateUser(UserDTO userDto);

	List<UserDTO> getUsers();

}
