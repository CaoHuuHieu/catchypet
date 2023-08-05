package com.catchypet.model.entity;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.catchypet.model.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetailsService {
	private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
//        UserEntity loadedUser = userRepository.findByUsername(username);
//        if (loadedUser == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(
//                loadedUser.getUsername(),
//                loadedUser.getPassword(),
//                true,
//                true,
//                true,
//                true,
//                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + loadedUser.getRole().toString()))
//        );
    	return null;
    }
}
