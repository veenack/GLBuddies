package com.glearning.employeemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.employeemgmt.entity.User;
import com.glearning.employeemgmt.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "Get Users", notes = "API to list all the available users")
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.findAllUsers();
	}

	@ApiOperation(value = "Create user", notes = "API to create a User")
	@PostMapping("/createUser")
	public String createUser(User user) {
		return userService.createUser(user);
	}

	@ApiOperation(value = "Delete User", notes = "API to a user with ID")
	@DeleteMapping("/deleteUser")
	public String deleteUser(Long userId) {
		return userService.deleteUser(userId);
	}

}
