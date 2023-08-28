package com.eduvoyager.DAO;

import java.util.List;

import com.eduvoyager.entity.User;

public interface UserDAO {

	User getUserByUsername(String username);

	User getUserById(int userId);

	void createUser(User user);

	List<User> getAllUsers(); // Added method

	void updateUser(User user); // Added method

	void deleteUser(int userId); // Added method

}
