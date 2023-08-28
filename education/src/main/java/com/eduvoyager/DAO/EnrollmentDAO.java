package com.eduvoyager.DAO;

import java.util.List;

import com.eduvoyager.entity.Course;
import com.eduvoyager.entity.Student;

public interface EnrollmentDAO {

	List<Course> getCoursesEnrolledByStudent(int studentId);

	List<Student> getStudentsEnrolledInCourse(int courseId);

	void enrollStudentInCourse(int studentId, int courseId);

}
