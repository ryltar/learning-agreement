package com.fges.rizomm.m1iii.learningagreementAPI.services.user;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.RpiDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.StudentDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.UserDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Admin;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Rpi;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Student;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.User;
import com.fges.rizomm.m1iii.learningagreementAPI.exception.userNotFound.UserNotFoundException;
import com.fges.rizomm.m1iii.learningagreementAPI.repository.user.UserRepository;
import com.fges.rizomm.m1iii.learningagreementAPI.services.SuperService;
import com.fges.rizomm.m1iii.learningagreementAPI.util.BCryptManagerUtil;
import com.fges.rizomm.m1iii.learningagreementAPI.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
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

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        userDTO.setPassword(BCryptManagerUtil.passwordencoder().encode(userDTO.getPassword()));
		List<RoleEnum> roleEnumList = Collections.singletonList(RoleEnum.STUDENT);
		return this.matchUser(userDTO, roleEnumList);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserWithName(email)
                .orElseThrow(() -> new UserNotFoundException(email));
    }

	@Override
	public List<UserDTO> getUsers() {
		return this.entityListToDtoList(userRepository.findAll());
	}

	@Override
    public UserDTO findOne(Long id) {
        return this.entityToDto(this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    @Override
    public UserDTO updateUser(UserDTO userDto, Long id) {
        User newUser = this.dtoToEntity(userDto);
        List<RoleEnum> roleEnumList = Collections.singletonList(RoleEnum.STUDENT);
        return this.userRepository.findById(id).map(user -> {
            UserDTO previousUser = this.entityToDto(user);
            if (!bcrypt.passwordMatch(previousUser.getPassword(), newUser.getPassword())) {
                newUser.setPassword(this.bcrypt.getPasswordEncoder().encode(newUser.getPassword()));
            }
            return matchUser(userDto, roleEnumList);
        }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public UserDTO matchUser(UserDTO userDTO, List<RoleEnum> roleEnumList) {
        if (userDTO.getRole() != null) {
            switch (userDTO.getRole()) {
                case ADMIN:
                    //User admin = (Admin) userDTO;
                    //return this.entityToDto(userRepository.save(admin));
                case STUDENT:
                    Student student = new Student(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFirstname(), userDTO.getLastname(), userDTO.getRoles());
                    return super.getMapper().map(userRepository.save(student), StudentDTO.class);
                case RPI:
                    Rpi rpi = new Rpi(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFirstname(), userDTO.getLastname(), userDTO.getRoles());
                    return super.getMapper().map(userRepository.save(rpi), RpiDTO.class);
                default:
                    student = new Student(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFirstname(), userDTO.getLastname(), userDTO.getRoles());
                    student.setRoles(roleEnumList);
                    return super.getMapper().map(userRepository.save(student), StudentDTO.class);
            }
        } else {
            Student student = new Student(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFirstname(), userDTO.getLastname(), userDTO.getRoles());
            student.setRoles(roleEnumList);
            return super.getMapper().map(userRepository.save(student), StudentDTO.class);
        }


    }
}
