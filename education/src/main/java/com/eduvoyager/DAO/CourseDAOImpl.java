package com.eduvoyager.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eduvoyager.entity.Course;

public class CourseDAOImpl implements CourseDAO {

	private Connection connection; // Initialize this connection

	@Override
	public Course getCourseById(int courseId) {
		String query = "SELECT * FROM courses WHERE course_id = ? AND is_deleted = 0";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, courseId);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					Course course = new Course();
					// Populate course object from resultSet
					return course;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		String query = "SELECT * FROM courses WHERE is_deleted = 0";
		try (PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Course course = new Course();
				// Populate course object from resultSet
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
		return courses;
	}

	@Override
	public List<Course> getCoursesByInstructor(int instructorId) {
		List<Course> courses = new ArrayList<>();
		String query = "SELECT * FROM courses WHERE instructor_id = ? AND is_deleted = 0";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, instructorId);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Course course = new Course();
					// Populate course object from resultSet
					courses.add(course);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
		return courses;
	}

	@Override
	public void createCourse(Course course) {
		String query = "INSERT INTO courses (course_name, instructor_id, is_deleted) VALUES (?, ?, 0)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, course.getCourseName());
			statement.setInt(2, course.getInstructorId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception
		}
	}

}
