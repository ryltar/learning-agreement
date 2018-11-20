package com.fges.rizomm.m1iii.learningagreementAPI.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.davidson.epack.services.user.UserServiceImpl;
import com.davidson.epack.util.BCryptManagerUtil;

public class AppAuthProvider extends DaoAuthenticationProvider {
    @Autowired
    UserServiceImpl userDetailsService;

    @Autowired
    BCryptManagerUtil bcrypt;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String name = auth.getName();
        String password = auth.getCredentials().toString();
        UserDetails user = userDetailsService.loadUserByUsername(name);
        if (user != null) {
            if (bcrypt.passwordMatch(password, user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            }
            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
        } else {
            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}