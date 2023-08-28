package com.eduvoyager.DAO;

import java.util.List;

import com.eduvoyager.entity.Course;

public interface CourseDAO {

	Course getCourseById(int courseId);

	List<Course> getAllCourses();

	List<Course> getCoursesByInstructor(int instructorId);

	void createCourse(Course course);

}
