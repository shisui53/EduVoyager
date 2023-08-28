package com.eduvoyager.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eduvoyager.entity.Course;
import com.eduvoyager.entity.Student;

public class EnrollmentDAOImpl implements EnrollmentDAO {

	private Connection connection; // Initialize this connection

	@Override
	public List<Course> getCoursesEnrolledByStudent(int studentId) {
		List<Course> enrolledCourses = new ArrayList<>();
		String query = "SELECT c.* FROM courses c " + "JOIN enrollments e ON c.course_id = e.course_id "
				+ "WHERE e.student_id = ? AND c.is_deleted = 0";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, studentId);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Course course = new Course();
					// Populate course object from resultSet
					enrolledCourses.add(course);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
		return enrolledCourses;
	}

	@Override
	public List<Student> getStudentsEnrolledInCourse(int courseId) {
		List<Student> enrolledStudents = new ArrayList<>();
		String query = "SELECT u.* FROM users u " + "JOIN enrollments e ON u.user_id = e.student_id "
				+ "WHERE e.course_id = ? AND u.is_deleted = 0";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, courseId);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Student student = new Student();
					// Populate student object from resultSet
					enrolledStudents.add(student);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
		return enrolledStudents;
	}

	@Override
	public void enrollStudentInCourse(int studentId, int courseId) {
		String query = "INSERT INTO enrollments (student_id, course_id, enrollment_date, is_deleted) "
				+ "VALUES (?, ?, CURRENT_TIMESTAMP, 0)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, studentId);
			statement.setInt(2, courseId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
	}
}
