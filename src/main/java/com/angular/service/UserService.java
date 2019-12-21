package com.angular.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.UserRepository;
import com.angular.entity.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> getUsers(){
		return repo.findAll();
	}
	
	public String regUser(User user) {
		repo.save(user);
		return "Your record Successfully Registered";
	}
	
	public List<User> getByEmail(String email) {
		System.out.println("email*****getting");
		return  repo.findByEmail(email);
	}
	
	public String deleteUser(int id) {
		repo.deleteById(id);
		return "Record Deleted Successfully";
	}
	
	public Optional<User> getUserById(int id) {
		System.out.println("*********");
		return repo.findById(id);
	}

}
