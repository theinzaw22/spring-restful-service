package com.theinzaw.webservice.rest.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping(path = "/users")
	public List<User> findAllUsers() {
		return service.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User findOneUser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null)
			throw new UserNotFountException("id-" + id);
		return user;
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteById(@PathVariable int id) {
		User user = service.deleteById(id);
		if (user == null) {
			throw new UserNotFountException("id-" + id);
		}
	}

	@PostMapping(path="/users")
		public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
			User savedUser = service.save(user);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
			return ResponseEntity.created(location).build();
		}

}
