package com.DeliveryMatch.DeliveryMatch.services.jwt;

import com.DeliveryMatch.DeliveryMatch.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserService {
    UserDetailsService userDetailsService();

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    Optional<User> findFirstByEmail(String email);


}
