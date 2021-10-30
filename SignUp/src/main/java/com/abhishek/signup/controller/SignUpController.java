package com.abhishek.signup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.signup.DTO.SignUpDTO;
import com.abhishek.signup.service.SignupServiceImpl;

@RestController
@RequestMapping("/signUpUser")
public class SignUpController {
	
	@Autowired
	public SignupServiceImpl signupService;

	@PostMapping("/signUp")
	public String addUser(@RequestBody SignUpDTO user) {
		signupService.addUser(user);
		return "Success";
	}
	
	@GetMapping("/getAllUser")
	public List<SignUpDTO> getAllUsers(){
		List<SignUpDTO> allUsers = signupService.getAllUsers();
		return allUsers;
	}
	
	@GetMapping("/getUser/{id}")
	public SignUpDTO getUser(@PathVariable Integer id) {
		SignUpDTO user = signupService.getUser(id);
		return user;
	}
	
	@PutMapping("/updateUser/{id}")
	public String updateUser(@PathVariable Integer id, @RequestBody SignUpDTO user) {
		signupService.updateUser(id, user);
		return "User Updated Successfully";
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Integer id) {
		signupService.deleteUser(id);
		return "User Deleted Successfully";
	}
	
}
