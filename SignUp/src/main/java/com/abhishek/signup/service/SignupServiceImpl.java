package com.abhishek.signup.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.signup.DTO.SignUpDTO;
import com.abhishek.signup.entity.SignUp;
import com.abhishek.signup.repository.SignUpRepository;

@Service
public class SignupServiceImpl implements SignupService{

	@Autowired
	public SignUpRepository signUpRepository;
	
//	@Autowired
//	public SignUp signup;

	@Override
	public void addUser(SignUpDTO user) {
		SignUp newUser = new SignUp();
		newUser.setName(user.getUserName());
		newUser.setEmailId(user.getEmailId());
		newUser.setMobileNo(user.getMobileNo());
		signUpRepository.save(newUser);
	}

	@Override
	public SignUpDTO getUser(Integer userId) {
		SignUpDTO user = new SignUpDTO();
		Optional<SignUp> getUserFromRepo = signUpRepository.findById(userId);
		SignUp signedUpuser = getUserFromRepo.get();
		user.setUserId(signedUpuser.getId());
		user.setUserName(signedUpuser.getName());
		user.setEmailId(signedUpuser.getEmailId());
		user.setMobileNo(signedUpuser.getMobileNo());
		return user;
	}

	@Override
	public List<SignUpDTO> getAllUsers() {
		Iterable<SignUp> allUsers = signUpRepository.findAll();
		List<SignUpDTO> allUserDto = new LinkedList<>();
		
		allUsers.forEach(user -> {
			SignUpDTO iteratedUser = new SignUpDTO();
			iteratedUser.setUserId(user.getId());
			iteratedUser.setUserName(user.getName());
			iteratedUser.setMobileNo(user.getMobileNo());
			iteratedUser.setEmailId(user.getEmailId());
			allUserDto.add(iteratedUser);
		});
		
		return allUserDto;
	}

	@Override
	public void updateUser(Integer id, SignUpDTO users) {
		Optional<SignUp> optionalUser = signUpRepository.findById(id);
		
		SignUp user = optionalUser.get();
		
		user.setName(users.getUserName());
		user.setEmailId(users.getEmailId());
		user.setMobileNo(users.getMobileNo());
		user.setEmailId(users.getEmailId());
		
		signUpRepository.save(user);
		
	}

	@Override
	public void deleteUser(Integer userId) {
		signUpRepository.deleteById(userId);
	}
	
	
}
