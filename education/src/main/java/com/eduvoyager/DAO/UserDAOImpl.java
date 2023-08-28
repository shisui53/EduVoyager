package com.eduvoyager.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eduvoyager.entity.User;
import com.eduvoyager.exception.UserNotFoundException;

public class UserDAOImpl implements UserDAO {

	private Connection connection;

	@Override
	public User getUserByUsername(String username) {
		String query = "SELECT * FROM users WHERE username = ? AND is_deleted = 0";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					User user = new User();
					// Populate user object from resultSet
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
		return null;
	}

	@Override
	public User getUserById(int userId) {
		String query = "SELECT * FROM users WHERE user_id = ? AND is_deleted = 0";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, userId);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					User user = new User();
					// Populate user object from resultSet
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
		return null;
	}

	@Override
	public void createUser(User user) {
		String query = "INSERT INTO users (username, password, role, is_deleted) VALUES (?, ?, ?, 0)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getRole());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
	}

	@Override
	public void updateUser(User user) {
		String query = "UPDATE users SET username = ?, password = ?, role = ? WHERE user_id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getRole());
			statement.setInt(4, user.getUserId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM users WHERE is_deleted = 0";
		try (PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				User user = new User();
				// Populate user object from resultSet
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
		return users;
	}

	@Override
	public void deleteUser(int userId) {
		String query = "UPDATE users SET is_deleted = 1 WHERE user_id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, userId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
	}

	@Override
	public User getUserById(int userId) {
		User user;
		// Implementation
		if (user == null) {
			throw new UserNotFoundException("User with ID " + userId + " not found.");
		}
		return user;
	}
}
