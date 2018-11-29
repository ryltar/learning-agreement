package com.fges.rizomm.m1iii.learningagreementAPI.services.user;

import com.davidson.epack.converter.AbstractConverter;
import com.davidson.epack.dto.user.CreateUserDTO;
import com.davidson.epack.dto.user.SetPasswordDTO;
import com.davidson.epack.dto.user.UserDTO;
import com.davidson.epack.entity.place.Place;
import com.davidson.epack.entity.user.User;
import com.davidson.epack.repository.UserRepository;
import com.davidson.epack.services.place.PlaceService;
import com.davidson.epack.services.place.SiteService;
import com.davidson.epack.services.siteGroup.SiteGroupService;
import com.davidson.epack.util.BCryptManagerUtil;
import com.davidson.epack.util.RoleEnum;
import com.davidson.epack.util.SendEmail;
import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.UserDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.repository.user.UserRepository;
import com.fges.rizomm.m1iii.learningagreementAPI.util.BCryptManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	    
	@Autowired
    BCryptManagerUtil bcrypt;
	
	@Autowired
	SendEmail sendEmail;
	    
	@Autowired
	SiteService siteService;
	
	@Autowired
	SiteGroupService siteGroupService;

	@Autowired
	AbstractConverter<User, UserDTO> userConverter;
	
	@Autowired
	PlaceService placeService;
	
	@Autowired
	AbstractConverter<User, CreateUserDTO> createUserConverter;

	public UserDTO addUser(CreateUserDTO createUserDto) {
		UserDTO userDto = null;
//		String password = bcrypt.generatePassword();
		User user = createUserConverter.DtoToEntity(createUserDto);
		Place place = placeService.findById(createUserDto.getIdPlace());
		user.setPlace(place);
		user.setToken(Long.toString(System.currentTimeMillis()));
//		user.setPassword(BCryptManagerUtil.passwordencoder().encode(password));
        try {
            user = userRepository.save(user);
//			sendEmail.sendPassword(user, password);
            sendEmail.sendEmailConfirmation(user);
        } catch (Exception e) {
            return null;
        }
        return userConverter.entityToDTO(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Objects.requireNonNull(email);
        return userRepository.findUserWithName(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


	@Override
	public List<UserDTO> getUsers(Long idSite) {
		return userConverter.entityListToDtoList(userRepository.findByPlaceId(idSite));
	}

	@Override
	public User findById(Long idUser) {
		return userRepository.findById(idUser).get();
	}

    @Override
    public UserDTO updateUser(UserDTO userDto) {
        User user = userRepository.findById(userDto.getIdUser()).get();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setUsername(userDto.getUsername());
        user.setRoles(userDto.getRoles());
        return userConverter.entityToDTO(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userConverter.entityToDTO(userRepository.findById(id).get());
    }

    @Override
    public Void changeUserStatus(Long idUser) {
        User user = userRepository.findById(idUser).get();
        user.setEnabled(!user.isEnabled());
        userRepository.save(user);
        return null;
    }

    @Override
    public UserDTO getUserDtoByEmail(String email) {
        return userConverter.entityToDTO(userRepository.findByUsername(email));
    }

    @Override
    public void sendEmailForNewPassword(User user) throws UnsupportedEncodingException, MessagingException {
        user.setPassHasBeenSet(false);
        user.setToken(Long.toString(System.currentTimeMillis()));
        user = userRepository.save(user);
        sendEmail.resetPassword(user);
    }

    @Override
    public User getUserByUsername(String email) {
        return userRepository.findByUsername(email);
    }

    @Override
    public UserDTO getUserByToken(String token) {
        if (userRepository.findByToken(token) != null)
            return userConverter.entityToDTO(userRepository.findByToken(token));
        return null;
    }

    @Override
    public UserDTO setPassword(SetPasswordDTO setPasswordDto) {
        User user = userRepository.findById(setPasswordDto.getIdUser()).get();
        user.setPassword(setPasswordDto.getPassword());
        user.setPassHasBeenSet(true);
        user.setEnabled(true);
        return userConverter.entityToDTO(userRepository.save(user));
    }
}
