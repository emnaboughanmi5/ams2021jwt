package tn.com.sip.ams.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.com.sip.ams.entities.User;
import tn.com.sip.ams.repositories.UserRepository;
import tn.com.sip.ams.service.UserService;

@RestController
@RequestMapping("api/users")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@PostMapping("")
	public User addUser(@RequestBody User user) {
		return userService.signUp(user);
	}
	@GetMapping("/list")
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
		return userRepository.findById(userId).map(user -> {
		    userRepository.delete(user);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new IllegalArgumentException("userId " + userId + " not found"));
	}
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable Long userId, @Valid @RequestBody User userRequest) {
		return userRepository.findById(userId).map(user -> {
		  
			return userRepository.save(user);
		}).orElseThrow(() -> new IllegalArgumentException("ProviderId " + userId + " not found"));
	}
	@GetMapping("/{userId}")
	public User getUser(@PathVariable Long userId) {
		Optional<User> p = userRepository.findById(userId);
		return p.get();
	}

}
