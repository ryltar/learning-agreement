package com.fges.rizomm.m1iii.learningagreementAPI.services.user;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.UserDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.User;
import com.fges.rizomm.m1iii.learningagreementAPI.repository.user.UserRepository;
import com.fges.rizomm.m1iii.learningagreementAPI.services.SuperService;
import com.fges.rizomm.m1iii.learningagreementAPI.util.BCryptManagerUtil;
import com.fges.rizomm.m1iii.learningagreementAPI.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserService extends SuperService<User,UserDTO>  implements IUserService, UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptManagerUtil bcrypt;

    @Autowired
    public UserService(UserRepository userRepository,
                       BCryptManagerUtil bcrypt) {
        this.userRepository = userRepository;
        this.bcrypt = bcrypt;
    }

    public UserDTO entityToDto(User entity) {
        return super.getMapper().map(entity, UserDTO.class);
    }

    public User dtoToEntity(UserDTO dto) {
        return super.getMapper().map(dto, User.class);
    }


    public UserDTO addUser(UserDTO userDTO) {
		User user = this.dtoToEntity(userDTO);
		user.setToken(Long.toString(System.currentTimeMillis()));
		user.setPassword(BCryptManagerUtil.passwordencoder().encode(userDTO.getPassword()));
        user = userRepository.save(user);
        return this.entityToDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserWithName(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

	@Override
	public List<UserDTO> getUsers() {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<RoleEnum> roles = userDetails.getRoles();
		return this.entityListToDtoList(userRepository.findByCurrentRole(roles.toArray()[0].toString()));
	}

    @Override
    public UserDTO updateUser(UserDTO userDto) {
        User user = userRepository.findById(userDto.getId()).get();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setUsername(userDto.getUsername());
        user.setRoles(userDto.getRoles());
        return this.entityToDto(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
	    User user = userRepository.findById(id).get();
        return this.entityToDto(user);
    }

}
