package com.angular.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.entity.User;
import com.angular.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class AngularController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/index")
	public String get() {
		return "index";
	}
	
	@RequestMapping("/index")	
	public String get1() {	
		return "india";	
	}	
	

	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return service.getUsers();
	}
	
	@PostMapping("/reg")
	public String RegUser(@RequestBody User user) {
		System.out.println("********reg");
		return service.regUser(user);
	}
	
	@GetMapping("/user/{email}")
	public List<User> getUserByMail(@PathVariable("email") String email) {
		
		return service.getByEmail(email);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		return service.deleteUser(id);
	}
	
	@GetMapping("/user/id/{id}")
	public Optional<User> findUserById(@PathVariable("id") int id) {
		return service.getUserById(id);
	}

}
