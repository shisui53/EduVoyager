package com.eduvoyager.service;

import java.util.List;

import com.eduvoyager.DAO.GradeDAO;
import com.eduvoyager.entity.Grade;
import com.eduvoyager.exception.GradeException;

public class GradeService {

	private GradeDAO gradeDAO; // Inject GradeDAO dependency here

	public List<Grade> getGradesForStudent(int studentId) {
		return gradeDAO.getGradesForStudent(studentId);
	}

	public List<Grade> getGradesForAssignment(int assignmentId) {
		return gradeDAO.getGradesForAssignment(assignmentId);
	}

	public void recordGrade(Grade grade) {
		// Check if the student is already graded before recording
		List<Grade> studentGrades = getGradesForStudent(grade.getEnrollmentId());
		for (Grade existingGrade : studentGrades) {
			if (existingGrade.getAssignment().getAssignmentId() == grade.getAssignmentId()) {
				throw new GradeException("Grade already recorded for this assignment.");
			}
		}
		gradeDAO.recordGrade(grade);
	}

}
