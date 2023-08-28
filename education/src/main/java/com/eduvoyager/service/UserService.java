package com.eduvoyager.service;

import java.util.List;

import com.eduvoyager.DAO.UserDAO;
import com.eduvoyager.entity.User;
import com.eduvoyager.exception.UserNotFoundException;

public class UserService {

	private UserDAO userDAO; // Inject UserDAO dependency here

	public User getUserById(int userId) {
		User user = userDAO.getUserById(userId);
		if (user == null) {
			throw new UserNotFoundException("User with ID " + userId + " not found.");
		}
		return user;
	}

	public void createUser(User user) {
		userDAO.createUser(user);
	}

	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);
	}

}
