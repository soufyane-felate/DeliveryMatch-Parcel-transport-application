package com.DeliveryMatch.DeliveryMatch.services.auth;

import com.DeliveryMatch.DeliveryMatch.dto.SignupRequest;
import com.DeliveryMatch.DeliveryMatch.dto.UserDto;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthService extends UserDetailsService {

    UserDto createUser(SignupRequest signupRequest);


    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
