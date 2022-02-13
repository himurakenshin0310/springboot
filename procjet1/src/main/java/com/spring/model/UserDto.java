package com.spring.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private long id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private boolean enable;
}
