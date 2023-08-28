package com.eduvoyager.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eduvoyager.entity.Grade;

public class GradeDAOImpl implements GradeDAO {

	private Connection connection; // Initialize this connection

	@Override
	public List<Grade> getGradesForStudent(int studentId) {
		List<Grade> grades = new ArrayList<>();
		String query = "SELECT * FROM grades WHERE student_id = ? AND is_deleted = 0";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, studentId);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Grade grade = new Grade();
					// Populate grade object from resultSet
					grades.add(grade);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
		return grades;
	}

	@Override
	public List<Grade> getGradesForAssignment(int assignmentId) {
		List<Grade> grades = new ArrayList<>();
		String query = "SELECT * FROM grades WHERE assignment_id = ? AND is_deleted = 0";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, assignmentId);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Grade grade = new Grade();
					// Populate grade object from resultSet
					grades.add(grade);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
		return grades;
	}

	@Override
	public void recordGrade(Grade grade) {
		String query = "INSERT INTO grades (enrollment_id, assignment_id, grade, is_deleted) " + "VALUES (?, ?, ?, 0)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, grade.getEnrollmentId());
			statement.setInt(2, grade.getAssignmentId());
			statement.setDouble(3, grade.getGrade());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
	}
}
