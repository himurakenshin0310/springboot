package com.spring.security;

import com.spring.model.UserDto;

public interface UserService {
	void regsignUser(UserDto userDto);
	boolean EmailExsit(String email);
}
