package com.eduvoyager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gradeId;

	@ManyToOne
	private int enrollment;

	@ManyToOne
	private int assignment;

	private double grade;
	private boolean isDeleted;

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public int getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(int enrollmentId) {
		this.enrollment = enrollmentId;
	}

	public int getAssignment() {
		return assignment;
	}

	public void setAssignment(int assignmentId) {
		this.assignment = assignmentId;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getEnrollmentId() {
		// TODO Auto-generated method stub
		return getEnrollmentId();
	}

	public int getAssignmentId() {
		// TODO Auto-generated method stub
		return getAssignmentId();
	}

}
