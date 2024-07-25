package com.mobile.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.demo.entity.User;
import com.mobile.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(Long userid) {
		return userRepository.findById(userid).orElse(null);
	}
	
//	public void deleteUserById(Long userid) {
//		 userRepository.deleteById(userid);
//	}
	
	public boolean deleteUserById(Long userid) {
		User eu = userRepository.findById(userid).orElse(null);
		if(eu != null) {
			userRepository.delete(eu);
			return true;
		}
		return false;
	}
}
