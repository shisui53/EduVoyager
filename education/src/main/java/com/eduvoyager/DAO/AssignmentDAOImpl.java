package com.eduvoyager.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eduvoyager.entity.Assignment;

public class AssignmentDAOImpl implements AssignmentDAO {

	private Connection connection; // Initialize this connection

	@Override
	public Assignment getAssignmentById(int assignmentId) {
		String query = "SELECT * FROM assignments WHERE assignment_id = ? AND is_deleted = 0";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, assignmentId);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					Assignment assignment = new Assignment();
					// Populate assignment object from resultSet
					return assignment;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
		return null;
	}

	@Override
	public List<Assignment> getAssignmentsForCourse(int courseId) {
		List<Assignment> assignments = new ArrayList<>();
		String query = "SELECT * FROM assignments WHERE course_id = ? AND is_deleted = 0";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, courseId);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Assignment assignment = new Assignment();
					// Populate assignment object from resultSet
					assignments.add(assignment);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
		return assignments;
	}

	@Override
	public void createAssignment(Assignment assignment) {
		String query = "INSERT INTO assignments (course_id, assignment_name, due_date, is_deleted) "
				+ "VALUES (?, ?, ?, 0)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, assignment.getCourseId());
			statement.setString(2, assignment.getAssignmentName());
			statement.setDate(3, new java.sql.Date(assignment.getDueDate().getTime()));
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
	}

}
