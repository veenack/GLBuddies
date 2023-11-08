package com.glearning.employeemgmt.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.glearning.employeemgmt.entity.User;
import com.glearning.employeemgmt.repository.UserRepository;
import com.glearning.employeemgmt.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public String createUser(User user) {
		userRepository.save(user);
		return "User "+user+" created";
	}

	@Override
	public User findUserById(Long userId) {
		User user = userRepository.findById(userId).get();
		return user;
	}

	@Override
	public String deleteUser(Long userId) {
		userRepository.deleteById(userId);
		return "User with id "+userId+" deleted";
	}

}
