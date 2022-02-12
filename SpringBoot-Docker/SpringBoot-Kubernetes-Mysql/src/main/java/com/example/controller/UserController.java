package com.example.controller;


import com.example.entity.User;
import com.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;
	
	@PostMapping("/addUser")
	public String saveUser(@RequestBody User emp) {
		userRepository.save(emp);
		return "User added successfully::"+emp.getId();
		
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/findUser/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return "Deleted User Successfully::"+id;
	}

	@GetMapping("/health/live")
	public String livelinessCheck() {
		logger.info("Health checking is happening.");
		return "fine";
	}

	@GetMapping("/health/ready")
	public String readinessCheck() {
		logger.info("Readiness checked.");
		return "fine";
	}
}