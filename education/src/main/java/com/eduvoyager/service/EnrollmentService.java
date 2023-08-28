package com.eduvoyager.service;

import java.util.List;

import com.eduvoyager.DAO.EnrollmentDAO;
import com.eduvoyager.entity.Course;
import com.eduvoyager.entity.Student;
import com.eduvoyager.exception.EnrollmentException;

public class EnrollmentService {

	private EnrollmentDAO enrollmentDAO; // Inject EnrollmentDAO dependency here

	public List<Course> getCoursesEnrolledByStudent(int studentId) {
		return enrollmentDAO.getCoursesEnrolledByStudent(studentId);
	}

	public List<Student> getStudentsEnrolledInCourse(int courseId) {
		return enrollmentDAO.getStudentsEnrolledInCourse(courseId);
	}

	public void enrollStudentInCourse(int studentId, int courseId) {
		// Check if the student is already enrolled before enrolling
		List<Course> enrolledCourses = getCoursesEnrolledByStudent(studentId);
		for (Course course : enrolledCourses) {
			if (course.getCourseId() == courseId) {
				throw new EnrollmentException("Student is already enrolled in this course.");
			}
		}
		enrollmentDAO.enrollStudentInCourse(studentId, courseId);
	}

}
