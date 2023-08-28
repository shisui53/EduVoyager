package com.eduvoyager.DAO;

import java.util.List;

import com.eduvoyager.entity.Grade;

public interface GradeDAO {

	List<Grade> getGradesForStudent(int studentId);

	List<Grade> getGradesForAssignment(int assignmentId);

	void recordGrade(Grade grade);

}
