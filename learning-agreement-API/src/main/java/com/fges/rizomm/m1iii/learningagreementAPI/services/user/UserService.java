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

import javax.management.relation.Role;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

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
        Objects.requireNonNull(email);
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
	public User findById(Long idUser) {
		return userRepository.findById(idUser).get();
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

    @Override
    public void changeUserStatus(Long idUser) {
        User user = userRepository.findById(idUser).get();
        user.setEnabled(!user.isEnabled());
        userRepository.save(user);
    }

    @Override
    public UserDTO getUserDtoByEmail(String email) {
	    User user = userRepository.findByUsername(email);
        return this.entityToDto(user);
    }

    @Override
    public User getUserByUsername(String email) {
        return userRepository.findByUsername(email);
    }

    @Override
    public UserDTO getUserByToken(String token) {
        User user = userRepository.findByToken(token);
        if (user != null){
            return this.entityToDto(user);
        }
        return null;
    }

    @Override
    public UserDTO setPassword(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId()).get();
        user.setPassword(userDTO.getPassword());
        user.setPassHasBeenSet(true);
        user.setEnabled(true);
        user = userRepository.save(user);
        return this.entityToDto(user);
    }

}
