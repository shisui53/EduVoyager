package com.eduvoyager.service;

import java.util.List;

import com.eduvoyager.DAO.CourseDAO;
import com.eduvoyager.entity.Course;
import com.eduvoyager.exception.CourseNotFoundException;

public class CourseService {

	private CourseDAO courseDAO; // Inject CourseDAO dependency here

	public Course getCourseById(int courseId) {
		Course course = courseDAO.getCourseById(courseId);
		if (course == null) {
			throw new CourseNotFoundException("Course with ID " + courseId + " not found.");
		}
		return course;
	}

	public List<Course> getAllCourses() {
		return courseDAO.getAllCourses();
	}

	public List<Course> getCoursesByInstructor(int instructorId) {
		return courseDAO.getCoursesByInstructor(instructorId);
	}

	public void createCourse(Course course) {
		courseDAO.createCourse(course);
	}

}
