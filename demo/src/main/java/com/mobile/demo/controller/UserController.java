package com.mobile.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.demo.entity.User;
import com.mobile.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	public User CreateUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userid}")
	public User getUserById(@PathVariable Long userid) {
		return userService.getUserById(userid);
	}
	
@DeleteMapping("/{userid}")
//public void deleteUser(@PathVariable Long userid) {
//	userService.deleteUserById(userid);
//}
//    @PutMapping("/{userid}")
//    public User updateUser(@PathVariable Long userid, @RequestBody User user) {
//    	user.setUserid(userid);
//    	return userService.saveUser(user);
//    }

public ResponseEntity<Void> deleteUserById(@PathVariable Long userid){
	boolean deleted = userService.deleteUserById(userid);
	if(deleted) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}else {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
    
	
}
