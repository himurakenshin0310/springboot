package com.spring.model;

import com.spring.entity.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeDto {
	private long id;
	private String name;
	private boolean status;
	
	public static TypeDto create(Type type) {
		TypeDto t = new TypeDto();
		t.setId(type.getId());
		t.setName(type.getName());
		t.setStatus(type.isStatus());
		return t;
	}
}
