package com.angular;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angular.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	List<User> findByEmail(String email);

}
