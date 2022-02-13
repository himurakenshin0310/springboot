package com.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select u from User u join fetch u.userRole where u.email = ?1")
	User findByemail(String email);
}
