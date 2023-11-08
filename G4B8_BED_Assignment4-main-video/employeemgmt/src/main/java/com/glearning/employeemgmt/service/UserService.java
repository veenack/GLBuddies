package com.glearning.employeemgmt.service;

import java.util.List;

import com.glearning.employeemgmt.entity.User;

public interface UserService {
	List<User> findAllUsers();

	String createUser(User user);

	User findUserById(Long userId);

	String deleteUser(Long userId);
}
