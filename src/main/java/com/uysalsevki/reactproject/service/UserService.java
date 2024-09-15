package com.uysalsevki.reactproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.uysalsevki.reactproject.entities.User;
import com.uysalsevki.reactproject.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	public User getUserById(@PathVariable Long userId) {
		
		return repository.findById(userId).orElse(null);
	}
	public User createUser(@RequestBody User newUser) {
		return repository.save(newUser);
	}
	public User updateUser(@PathVariable Long userId, @RequestBody User updateUser) {
		Optional<User> user=repository.findById(userId);
		if(user.isPresent()) {
			User foundUser=user.get();
			foundUser.setPassword(updateUser.getPassword());
			foundUser.setUsername(updateUser.getUsername());
			return repository.save(foundUser);
		}
		return null;
	}
	public void deleteUser(@PathVariable Long userId) {
		repository.deleteById(userId);
	}

}
