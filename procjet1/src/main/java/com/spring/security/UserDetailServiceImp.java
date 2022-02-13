package com.spring.security;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.entity.User;
import com.spring.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UserDetailServiceImp implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserDetailServiceImp userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByemail(username);
		if (Objects.isNull(user))
			throw new UsernameNotFoundException("dont have this username!");
		return new CustomUserDetail(user);
	}

}
