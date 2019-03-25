package com.fges.rizomm.m1iii.learningagreementAPI.services.user;

import java.util.List;
import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.UserDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.User;
import com.fges.rizomm.m1iii.learningagreementAPI.util.RoleEnum;

public interface IUserService {

	UserDTO updateUser(UserDTO userDto, Long id);

	List<UserDTO> getUsers();

	UserDTO findOne(Long id);

	UserDTO addUser(UserDTO userDTO);

	UserDTO matchUser(User user, UserDTO userDTO, List<RoleEnum> roleEnumList);
}
