package com.eduvoyager.service;

import java.util.List;

import com.eduvoyager.DAO.AssignmentDAO;
import com.eduvoyager.entity.Assignment;
import com.eduvoyager.exception.AssignmentException;

public class AssignmentService {

	private AssignmentDAO assignmentDAO; // Inject AssignmentDAO dependency here

	public Assignment getAssignmentById(int assignmentId) {
		Assignment assignment = assignmentDAO.getAssignmentById(assignmentId);
		if (assignment == null) {
			throw new AssignmentException("Assignment with ID " + assignmentId + " not found.");
		}
		return assignment;
	}

	public List<Assignment> getAssignmentsForCourse(int courseId) {
		return assignmentDAO.getAssignmentsForCourse(courseId);
	}

	public void createAssignment(Assignment assignment) {
		assignmentDAO.createAssignment(assignment);
	}

}
