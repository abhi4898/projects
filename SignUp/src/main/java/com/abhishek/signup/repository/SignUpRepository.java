package com.abhishek.signup.repository;

import org.springframework.data.repository.CrudRepository;

import com.abhishek.signup.entity.SignUp;

public interface SignUpRepository extends CrudRepository<SignUp, Integer> {
	
}
