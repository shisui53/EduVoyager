package com.eduvoyager.DAO;

import java.util.List;

import com.eduvoyager.entity.Assignment;

public interface AssignmentDAO {

	Assignment getAssignmentById(int assignmentId);

	List<Assignment> getAssignmentsForCourse(int courseId);

	void createAssignment(Assignment assignment);

}
