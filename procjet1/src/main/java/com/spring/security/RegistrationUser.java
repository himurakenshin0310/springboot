package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.entity.User;
import com.spring.entity.UserRole;
import com.spring.model.UserDto;
import com.spring.repository.RoleRepository;
import com.spring.repository.UserRepository;
import com.spring.repository.UserRoleRepository;
@Service
public class RegistrationUser implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	BCryptPasswordEncoder passwordEncode;

	@Autowired
	UserRoleRepository userRoleRepo;

	@Autowired
	RoleRepository roleRepo;

	@Override
	public void regsignUser(UserDto userDto) {
		if (EmailExsit(userDto.getEmail()))
			throw new UsernameNotFoundException("username already taken!");

		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setEnable(true);
		user.setName(userDto.getName());
		user.setPassword(passwordEncode.encode(userDto.getPassword()));
		user.setPhone(userDto.getPhone());
		userRepo.save(user);
		UserRole role = new UserRole();
		role.setRole(roleRepo.findById((long) 2).get());
		role.setUser(user);
		userRoleRepo.save(role);

	}

	@Override
	public boolean EmailExsit(String email) {
		return userRepo.findByemail(email) != null;
	}

}
