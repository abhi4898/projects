package com.abhishek.signup.service;

import java.util.List;

import com.abhishek.signup.DTO.SignUpDTO;

public interface SignupService {
	public void addUser(SignUpDTO user);
	public SignUpDTO getUser(Integer userId);
	public List<SignUpDTO> getAllUsers();
	public void updateUser(Integer id, SignUpDTO users);
	public void deleteUser(Integer userId);
}
