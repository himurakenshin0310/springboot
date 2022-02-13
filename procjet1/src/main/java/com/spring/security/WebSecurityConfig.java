package com.spring.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailServiceImp userService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncode());
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
		.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN")
		.antMatchers("/payment/**").hasAuthority("USER")
		.and()
		.formLogin().loginPage("/login").usernameParameter("email").loginProcessingUrl("/logining").permitAll().defaultSuccessUrl("/")
		.failureForwardUrl("/fail").and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).clearAuthentication(true).logoutSuccessUrl("/")
		.and().exceptionHandling().accessDeniedPage("/403")
		.and().rememberMe().key("23ád4564564ad213").rememberMeParameter("rmm").tokenValiditySeconds(60*60*24*14)
		;
		
	}
	
}
