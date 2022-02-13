package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.model.UserDto;

@Controller
@RequestMapping("/")
public class UserController {
	@GetMapping("login")
	public String getLogin(Model model) {
		model.addAttribute("user", new UserDto());
		return "backend/loginpage";
	}
}
