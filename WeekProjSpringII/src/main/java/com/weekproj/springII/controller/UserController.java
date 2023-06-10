package com.weekproj.springII.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weekproj.springII.entity.User;
import com.weekproj.springII.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserService us;

	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {

		return ResponseEntity.ok(us.getAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserByid(@PathVariable Long id) {
		return ResponseEntity.ok(us.getById(id));
}

//	@PostMapping
//	public ResponseEntity<User> createUser(@RequestBody User user) {
//		return ResponseEntity.ok(us.create(user));
//	}

	@PutMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id) {
		// try {
		
		return ResponseEntity.ok(us.update(user, id));
		// } catch (EntityExistsException e) {
		// return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		// }
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<String> deleteUserByid(@PathVariable Long id) {

		// try {
		return ResponseEntity.ok(us.remove(id));
		// } catch (EntityExistsException e) {
		// return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		// }
	}
}
